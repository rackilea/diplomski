//File file = new File("Chart.png"); -> this is already there
        FileInputStream fis = new FileInputStream(file);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int read= 0;
        while( (read = fis.read(buffer)) > -1){ 
            baos.write(buffer, 0, read);
        }
        fis.close();
        baos.close();
        byte pgnBytes [] = baos.toByteArray();
        Base64.Encoder base64_enc = Base64.getEncoder();
        String base64_image = base64_enc.encodeToString(pgnBytes);