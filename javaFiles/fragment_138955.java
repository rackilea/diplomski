@org.testng.annotations.Test
    public void test() throws IOException {
        System.out.println("inside test");
        open("https://www.google.co.in/");

        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("/Users/naveen/Desktop/screenshot1.png"));
        BufferedImage bi = ImageIO.read(new File("/Users/naveen/Desktop/screenshot1.png"));
        Graphics g = bi.getGraphics();
        g.setFont(g.getFont().deriveFont(30f));
        g.drawString("Hello World!", 100, 100);
        g.dispose();
        ImageIO.write(bi, "png", new File("/Users/naveen/Desktop/test1.png"));
    }