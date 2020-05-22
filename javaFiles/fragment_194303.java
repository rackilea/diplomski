String targetURL = cmbURL.getSelectedItem().toString();
            // add the URL to the combo model if it's not already there
            if (!targetURL
                .equals(
                    cmbURLModel.getElementAt(
                        cmbURL.getSelectedIndex()))) {
                cmbURLModel.addElement(targetURL);
            }

            PostMethod filePost = new PostMethod(targetURL);

            filePost.getParams().setBooleanParameter(HttpMethodParams.USE_EXPECT_CONTINUE,
            cbxExpectHeader.isSelected());
            try {
                appendMessage("Uploading " + targetFile.getName() + " to " + targetURL);
                Part[] parts = {
                    new FilePart(targetFile.getName(), targetFile)
                };
                filePost.setRequestEntity(
                    new MultipartRequestEntity(parts, filePost.getParams())
                    );
                HttpClient client = new HttpClient();
                client.getHttpConnectionManager().
                    getParams().setConnectionTimeout(5000);
                int status = client.executeMethod(filePost);
                if (status == HttpStatus.SC_OK) {
                    appendMessage(
                        "Upload complete, response=" + filePost.getResponseBodyAsString()
                    );
                } else {
                    appendMessage(
                        "Upload failed, response=" + HttpStatus.getStatusText(status)
                    );
                }
            } catch (Exception ex) {
                appendMessage("ERROR: " + ex.getClass().getName() + " "+ ex.getMessage());
                ex.printStackTrace();
            } finally {
                filePost.releaseConnection();
            }