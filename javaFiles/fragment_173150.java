WritableImage image = lc.snapshot(new SnapshotParameters(), null);  
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        try {
                ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", baos);
        } 
                catch (IOException e) {
                //bla
        } 
        byte pgnBytes [] = baos.toByteArray();
        Base64.Encoder base64_enc = Base64.getEncoder();
        String base64_image = base64_enc.encodeToString(pgnBytes);
     }