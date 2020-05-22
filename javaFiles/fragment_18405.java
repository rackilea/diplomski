private byte[] getJpg() throws IOException {
        BufferedImage bImage = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = (Graphics2D) bImage.getGraphics();
        DrawingContext context = new DrawingContext(g2d);
        PiePlot plot = getPlot();
        plot.draw(context);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DrawableWriter wr = DrawableWriterFactory.getInstance().get("image/jpeg");
        wr.write(plot, baos, 800, 600);
        baos.flush();
        byte[] bytes = baos.toByteArray();
        baos.close();
        return bytes;
    }