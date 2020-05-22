public ImagePlus composeImages(ArrayList<ImagePlus> imageList){
    int sumWidth = 0;
    int maxHeight = 0;

    for(ImagePlus imp : imageList){
        sumWidth = sumWidth +imp.getWidth();
        if(imp.getHeight() > maxHeight)
            maxHeight = imp.getWidth();

    }

    ImagePlus impComposite = new ImagePlus();

    ImageProcessor ipComposite = new ShortProcessor(sumWidth, maxHeight);

    for(int i=0; i<sumWidth; i++){
        for(int j=0; j<sumWidth; j++){

            ipComposite.putPixelValue(i, j, figureOutThis);

        }
    }

    impComposite.setProcessor(ipComposite);
    return impComposite;

}