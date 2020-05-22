try {
        File input = new File("srcImage.jpeg");
        BufferedImage image = ImageIO.read(input);

        File output = new File("dstImage.jfif");
        ImageIO.write(image, "jfif", output);

        System.out.println("Your image has been converted successfully");
    } catch(Excpetion e){
        System.out.println("Error:"+e.getMessage());
    }