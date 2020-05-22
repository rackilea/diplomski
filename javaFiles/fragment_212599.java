//----------snip
                InputStream inStream = bodyPart.getInputStream();
                //The outstream can be any output stream, I switch this to one that writes to memory (byte[]).      
                ByteArrayOutputStream outStream = new ByteArrayOutputStream();
                byte[] tempBuffer = new byte[4096]; // 4 KB
                int numRead;
                while ((numRead = inStream.read(tempBuffer)) != -1) {
                    outStream.write(tempBuffer);
                }

                //Handle object here
                byte[] attachment = outStream.toByteArray(); 

                //Pseudo Code Begins
                SQL.createAttachment(attachment); //I'm assuming there's a static method to do this
                inStream.close();
                outStream.close();
//-----------------snip