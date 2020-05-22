double featImageWidth = originalImage.getWidth();
        double featImageHeight = originalImage.getHeight();
        double ratio = featImageWidth/featImageHeight;             

        //this width meets your constraints
        int finalWidth = MAX_FEAT_IMAGE_WIDTH;

        //this final height is what the height would be to keep the same ratio.
        int finalHeight = (int)(finalWidth/ratio);

        if(finalHeight > MAX_FEAT_IMAGE_HEIGHT){
              //the height constrains the image.
              finalHeight = MAX_FEAT_IMAGE_HEIGHT;
              finalWidth = (int)(finalHeight*ratio)
         }