public void fetchImage() throws IOException{
                 URL obj = new URL(rest_url); 
                 HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

                 con.setDoOutput(true);
                 con.setRequestMethod("GET");
                 //specify your image file destination path
                 File destinationFile=new File("/destinationPath");
                 FileOutputStream outputStream=new FileOutputStream(destinationFile);
                 InputStream inputStream=con.getInputStream();
                 //start stream copy using a buffersize. here i am using a beffer size=1024
                 copyStream(inputStream, outputStream, 1024);
                 outputStream.close();
                 inputStream.close();
            }   

    /*copy an inputStream to an OutputStream using a specific buffer size*/
    public static OutputStream copyStream(InputStream is, OutputStream os, int buffer_size) throws IOException{


                            byte[] bytes = new byte[buffer_size];

                            for (; ; ) {
                                // Read byte from input stream

                                int count = is.read(bytes, 0, buffer_size);
                                if (count == -1)
                                    break;

                                // Write byte to output stream
                                os.write(bytes, 0, count);
                            }

                        return os;
                    }