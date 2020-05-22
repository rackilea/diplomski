ImageInputStream stream = ...;
Iterator<ImageReader> readers = ImageIO.getImageReaders(stream);
if (readers.hasNext()) {
    ImageReader reader = readers.next();

    try {
        reader.setInput(stream);

        ImageReadParam param = reader.getDefaultReadParam();

        Iterator<ImageTypeSpecifier> specs = reader.getImageTypes();

        while (specs.hasNext()) {
            ImageTypeSpecifier spec = specs.next();

            if (/*spec is for TYPE_INT_RGB*/) {
                // Either pass your pre-allocated image:
                reader.setDestination(image); 

                // *OR* simply tell the reader what type you like the result to be:
                reader.setDestinationType(spec);
            }
        }

        // TODO: Handle the case where there's no match among the ImageTypeSpecifiers

        // In case image was passed, it will be the same image returned here
        image = reader.read(0, param); 
    }
    finally {
        reader.dispose();
    }
}