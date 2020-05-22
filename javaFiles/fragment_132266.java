BufferedImageOp op = new ConvolveOp(new Kernel(3, 3,
    new float[] { 
        1/9f, 1/9f, 1/9f,
        1/9f, 1/9f, 1/9f,
        1/9f, 1/9f, 1/9f
    }
));

BufferedImage resultImg = op.filter(originalImg, resultImage);