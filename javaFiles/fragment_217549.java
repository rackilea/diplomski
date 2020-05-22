final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

                int c;
                while ((c = connection.getInputStream().read()) != -1) {
                    byteArrayOutputStream.write(c);
                }

                pdfStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());