switch (colorSpaceCode) {
    case JPEG.JCS_GRAYSCALE:
        list.add(raw);
        list.add(getImageType(JPEG.JCS_RGB));
        break;
    case JPEG.JCS_RGB:
        list.add(raw);
        list.add(getImageType(JPEG.JCS_GRAYSCALE));
        list.add(getImageType(JPEG.JCS_YCC));
        break;
    case JPEG.JCS_RGBA:
        list.add(raw);
        break;
    case JPEG.JCS_YCC:
        if (raw != null) {  // Might be null if PYCC.pf not installed
            list.add(raw);
            list.add(getImageType(JPEG.JCS_RGB));
        }
        break;
    case JPEG.JCS_YCCA:
        if (raw != null) {  // Might be null if PYCC.pf not installed
            list.add(raw);
        }
        break;
    case JPEG.JCS_YCbCr:
        // As there is no YCbCr ColorSpace, we can't support
        // the raw type.

        // due to 4705399, use RGB as default in order to avoid
        // slowing down of drawing operations with result image.
        list.add(getImageType(JPEG.JCS_RGB));

        if (iccCS != null) {
            list.add(new ImageTypeProducer() {
                protected ImageTypeSpecifier produce() {
                    return ImageTypeSpecifier.createInterleaved
                     (iccCS,
                      JPEG.bOffsRGB,  // Assume it's for RGB
                      DataBuffer.TYPE_BYTE,
                      false,
                      false);
                }
            });

        }

        list.add(getImageType(JPEG.JCS_GRAYSCALE));
        list.add(getImageType(JPEG.JCS_YCC));
        break;
    case JPEG.JCS_YCbCrA:  // Default is to convert to RGBA
        // As there is no YCbCr ColorSpace, we can't support
        // the raw type.
        list.add(getImageType(JPEG.JCS_RGBA));
        break;
}