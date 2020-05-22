@RequestMapping(value= "/test", method = RequestMethod.GET)
    public void dynamicImage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("image/png");
        ServletOutputStream out = response.getOutputStream();

        // Create an image buffer that supports alpha
        BufferedImage image = new BufferedImage(200, 40, BufferedImage.TYPE_INT_ARGB);

        // Create a graphics context and turn antialiasing on
        Graphics2D graphics = image.createGraphics();
        graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        // Comic Sans FTW
        Font font = new Font("Comic Sans MS", Font.BOLD, 30);
        graphics.setFont(font);
        graphics.setColor(Color.RED);
        graphics.drawString("Hello World!", 5, 30);

        // Dispose of the context
        graphics.dispose();

        // Encode to png
        ImageIO.write(image, "PNG", out);
    }