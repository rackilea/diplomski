for (const Map<String, Object> element : (List<Map<String, Object>>) result.get("root")) {
    // The "element" object has an "images" value that is a list of objects
    for (const Map<String, Object> image : (List<Map<String, Object>>) element.get("images")) {
        // Save the "src" field of each image
        productImages.add((String) image.get("src"));
    }
}