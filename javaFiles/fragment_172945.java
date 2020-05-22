httpHeader= (h+" 200 OK \n" +
                            "Content-Type: image/gif"+"\n" +
                            "Content-Length: "+f.length()+"\n\n");
                    //Send header to the client
                    out.println(cabecera);
                    out.flush();
                    //Send gif file content to the cliente
                    returnGIF(f);


    private void returnGIF(File f) throws IOException{
        FileInputStream fis = new FileInputStream(f.getPath());
        int b=0;
        while ((b=fis.read()) != -1){
            out_bis.write(b);
        }
        fis.close();
    }