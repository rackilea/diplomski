try{    
            URL url = new URL("http://docs.oracle.com/javase/7/docs/api/java/io/FileOutputStream.html");
            String path = "D://StackOverflow/";
            InputStream ins = url.openStream();
            OutputStream ous = new FileOutputStream(path);
            final byte[] b = new byte[2048];
            int length;

                while ((length = ins.read(b)) != -1) {
                       ous.write(b, 0, length);
                 }

                   ins.close();
                   ous.close();
        } catch(Exception e){
            e.printStackTrace();
        }