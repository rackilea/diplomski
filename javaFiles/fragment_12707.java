BufferedImage bi = new BufferedImage(110, 110, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = bi.createGraphics();
        AffineTransform saveTX = new AffineTransform();
        saveTX.translate(translateX, translateY);
        saveTX.scale(0.2, 0.2);
        g2.setTransform(saveTX);
        this.paint(g2);

        ImageInputStream bigInputStream = ImageIO.createImageInputStream(bi);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(bi, "BMP", baos);
        byte[] bytes = baos.toByteArray();
        String dataImg = new Base64().encodeBase64String(bytes);

        PostMethod post = new PostMethod("http://localhost:3001/upload/file");

        post.addParameter("upload[test]", dataImg);

        HttpClient client = new HttpClient();
        int status = client.executeMethod(post);

        g2.dispose();