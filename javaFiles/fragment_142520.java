Interleaved2Of5Bean bean = new Interleaved2Of5Bean();

    bean.setHeight(10d);

    bean.doQuietZone(false);

    OutputStream out =
        new java.io.FileOutputStream(new File("output.png"));

    BitmapCanvasProvider provider =
        new BitmapCanvasProvider(out, "image/x-png", 110,
                                 BufferedImage.TYPE_BYTE_GRAY, false,
                                 0);
    bean.generateBarcode(provider, request.getParameter("barcode"));

    provider.finish();

    BufferedImage barcodeImage = provider.getBufferedImage();
    response.setContentType("image/x-png");
    OutputStream outputStream = response.getOutputStream();
    ImageIO.write(barcodeImage, "png", outputStream);
    outputStream.close();