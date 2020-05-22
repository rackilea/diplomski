public static String encodeToString(BufferedImage image, String type) {  
        String imageString = null;  
        ByteArrayOutputStream bos = new ByteArrayOutputStream();  

        try {  
            ImageIO.write(image, type, bos);  
            byte[] imageBytes = bos.toByteArray();  

            BASE64Encoder encoder = new BASE64Encoder();  
            imageString = encoder.encode(imageBytes);  

            bos.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        return imageString;  
    }