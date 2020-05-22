BufferedImage src = ImageIO.read(new File("/Users/swhitehead/Downloads/original.jpg"));

        System.out.println(src.getWidth() + "x" + src.getHeight());
        BufferedImage rotated = Scalr.rotate(src, Scalr.Rotation.CW_90, Scalr.OP_ANTIALIAS);
        BufferedImage scaled = Scalr.resize(rotated, Scalr.Method.SPEED, Scalr.Mode.FIT_TO_HEIGHT, 1336, 768, Scalr.OP_ANTIALIAS);
        System.out.println(scaled.getWidth() + "x" + scaled.getHeight());
        ImageIO.write(scaled, "jpg", new File("Scaled.jpg"));