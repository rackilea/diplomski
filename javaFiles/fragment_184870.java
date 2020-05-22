for(String s: others){

            URL url = new URL("http://otherserver.com" + s);
            System.out.println("Reading " + s);
            try{
                int toSub = s.lastIndexOf("/");
                String entryString = s.substring(toSub+1);
                out.putNextEntry(new ZipEntry(entryString));

                BufferedInputStream in = new BufferedInputStream(url.openStream());
                ByteArrayOutputStream baos2 = new ByteArrayOutputStream();
                BufferedOutputStream out2 = new BufferedOutputStream(baos2);
                int i;
                while ((i = in.read()) != -1) {
                    out2.write(i);
                }
                out2.flush();
                byte[] data = baos2.toByteArray();
                // closing all the shits
                out2.close();
                in.close();
                out.write(data,0,data.length);  
                out.closeEntry();

                System.out.println(entryString + " packaged...");
            }catch(Exception e){
                e.printStackTrace();
            }           
    }