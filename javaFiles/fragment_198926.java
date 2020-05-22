@Override
            public void handle(HttpExchange t) throws IOException {
                try {
                    System.out.println("Req\t" + t.getRemoteAddress());
                    InputStream initialStream = t.getRequestBody();
                    File targetFile = new File(FILE_PATH + simpleDateFormat.format(new Date()) + FILE_TYPE);
                    OutputStream outStream = new FileOutputStream(targetFile, true);
                    // This will copy ENTIRE input stream into your target file
                    IOUtils.copy(initialStream, outStream);
                    outStream.close();

                    t.sendResponseHeaders(204, -1);
                    t.close();
                } catch(IOException e) {
                    e.printStackTrace();
                    throw e;
                }
            }