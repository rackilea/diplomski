// Check if we have the image in our cache
    String key = IMG_URL_PATH + mi.getUniqueId();
    Object image = imgs.get(key);
    if (image != null) {
        // Carry over to new cache
        newImgs.put(key, image);
    }