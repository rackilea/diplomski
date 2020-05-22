...
case PNG_COLOR_RGB_ALPHA:
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