public void captureAndSaveDisplay(){
    FileChooser fileChooser = new FileChooser();

    //Set extension filter
    fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("png files (*.png)", "*.png"));

    //Prompt user to select a file
    File file = fileChooser.showSaveDialog(null);

    if(file != null){
        try {
            //Pad the capture area
            WritableImage writableImage = new WritableImage((int)getWidth() + 20,
                    (int)getHeight() + 20);
            snapshot(null, writableImage);
            RenderedImage renderedImage = SwingFXUtils.fromFXImage(writableImage, null);
            //Write the snapshot to the chosen file
            ImageIO.write(renderedImage, "png", file);
        } catch (IOException ex) { ex.printStackTrace(); }
    }
}