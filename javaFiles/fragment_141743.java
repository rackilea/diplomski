for (int x = 0; x < img.getWidth(); x++)
    for (int y = 0; y < img.getHeight(); y++)
        // check if the RGB integer is an odd number
        if (img.getRGB(x, y) % 2 != 0)
            // make it an even number if it is odd (the OCD god demands it!)
            img.setRGB(x, y, 0); /// A ///