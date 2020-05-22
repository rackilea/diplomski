private void saveImage(final BufferedImage image, final String string, final File outputfile) throws IOException, InterruptedException {
        Thread thread = new Thread(new Runnable(){

            public void run() {
                try {
                    ImageIO.write(image, string, outputfile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        });
        thread.start();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageOutputStream ios = ImageIO.createImageOutputStream(baos);
            Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName(string);
            if (writers.hasNext()) {
                ImageWriter writer = writers.next();
                writer.addIIOWriteProgressListener(new IIOWriteProgressListener() {
                    public void imageStarted(ImageWriter source, int imageIndex) {
                    }

                    public void imageProgress(ImageWriter source, float percentageDone) {
                        System.out.println("UPDATE: " + percentageDone);//TODO
                    }

                    public void imageComplete(ImageWriter source) {
                    }

                    public void thumbnailStarted(ImageWriter source, int imageIndex, int thumbnailIndex) {
                    }

                    public void thumbnailProgress(ImageWriter source, float percentageDone) {
                    }

                    public void thumbnailComplete(ImageWriter source) {
                    }

                    public void writeAborted(ImageWriter source) {
                    }
                });

                writer.setOutput(ios);
                try {
                    writer.write(image);
                } finally {
                    writer.removeAllIIOWriteProgressListeners();
                }
            }

        thread.join();
    }