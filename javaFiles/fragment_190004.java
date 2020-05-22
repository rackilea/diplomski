OutputStream out = ...; // the servlet or socket output stream
BufferedImage image = ...; // the image you just created

if (!ImageIO.write(image, "PNG", out)) {
    log.warn("Could not write image...");
}