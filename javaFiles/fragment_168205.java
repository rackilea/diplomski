InputStream response = webResource.type(MediaType.MULTIPART_FORM_DATA_TYPE).post(InputStream.class,
                    formData);

            OutputStream out = null;
            int read = 0;
            byte[] bytes = new byte[1024];
            File file = new File("D:/Today/");
            if (!file.exists()) {
                file.mkdir();
                out = new FileOutputStream(new File(file + ".zip"));
                while ((read = response.read(bytes)) != -1) {
                    out.write(bytes, 0, read);
                }
                // new File(file +".zip").createNewFile();
            } else {
                out = new FileOutputStream(new File(file+ ".zip"));
                while ((read = response.read(bytes)) != -1) {
                    out.write(bytes, 0, read);
                }
            }

            out.flush();
            out.close();