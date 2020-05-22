for (int i = 0; i < rows; i++) {
    for (int k = 0; k < cols; k++) {
        BufferedImage buffImage = ImageIO.read(imgFiles[num]);
        finalImg.createGraphics().drawImage(buffImage, null,
                chunkWidth * k, chunkHeight * i);
        num++;
    }
}