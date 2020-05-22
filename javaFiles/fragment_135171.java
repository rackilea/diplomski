...
case PNG_COLOR_RGB_ALPHA:
    if (bitDepth == 8) {
        // some standard types of buffered images
        // wich can be used as destination
        l.add(ImageTypeSpecifier.createFromBufferedImageType(
                                           BufferedImage.TYPE_4BYTE_ABGR));

        l.add(ImageTypeSpecifier.createFromBufferedImageType(
                                           BufferedImage.TYPE_INT_ARGB));
    }

    // Component R, G, B, A (non-premultiplied)
    rgb = ColorSpace.getInstance(ColorSpace.CS_sRGB);
    bandOffsets = new int[4];
    bandOffsets[0] = 0;
    bandOffsets[1] = 1;
    bandOffsets[2] = 2;
    bandOffsets[3] = 3;

    l.add(ImageTypeSpecifier.createInterleaved(rgb,
                                               bandOffsets,
                                               dataType,
                                               true,
                                               false));
    break;