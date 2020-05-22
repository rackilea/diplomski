InputStream inputStream;
        try {
            inputStream = new FileInputStream("E:\\pics\\Original\\testCompress\\bouncy-crayon-playland-2.JPG");
            BufferedImage image = ImageIO.read(inputStream);              
            ImageWriter writer = ImageIO.getImageWritersByFormatName("jpeg").next();      
            ImageWriteParam param = writer.getDefaultWriteParam();
            param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
            param.setCompressionQuality(1);      
            writer.setOutput(ImageIO.createImageOutputStream(new File("E:\\pics\\Original\\testCompress\\bouncy-crayon-playland-2-compressed.JPG")));       
            writer.write(null, new IIOImage(image, null, null), param);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }