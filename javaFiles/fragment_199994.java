// 1 Scale image to avoid memory issues
    Image scaledImage = scaleImage(image);

    // 2. Encode image to png
    PngEncoderFX encoder = new PngEncoderFX(scaledImage, true);
    byte[] bytes = encoder.pngEncode();

    // 3. Write byte array to a file in public storage 
    ...