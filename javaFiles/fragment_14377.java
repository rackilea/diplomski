if (result.next()) {
                 // gets file name and file blob data
                String fileID = result.getString("image_id");
                Blob blob = result.getBlob(3);
                InputStream inputStream = blob.getBinaryStream();
                int length = (int)blob.length();
                ServletContext context = getServletContext();

                 // set content properties and header attributes for the response
                response.setContentType("image/jpeg");
                response.setContentLength(length);
                String headerKey = "Content-Disposition";
                String headerValue = String.format("attachment; filename=\"%s\"", fileID);
                 response.setHeader(headerKey, headerValue);

                 // writes the file to the client
                 OutputStream outStream = response.getOutputStream();
                 ServletOutputStream output = response.getOutputStream();
                 BufferedOutputStream bos = new BufferedOutputStream(output);
                 byte[] arr1 = blob.getBytes(1, length);
                 bos.write(arr1);

                inputStream.close();
                outStream.close();             
        }