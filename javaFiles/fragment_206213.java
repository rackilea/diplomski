List<Image> croppedImages = new ArrayList<Image>(4 * 3);

for ( int i = 0; i < 4; i++) {
    for ( int j = 0; j < 3; j++) {
        croppedImages.add(createImage(new FilteredImageSource(source.getSource(),
                    new CropImageFilter(j*width/3, i*height/4, 
                        (width/3)+1, height/4))));
    }
}

Collections.shuffle(croppedImages);