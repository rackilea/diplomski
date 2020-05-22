String text = "<li>Coffee</li><li>Tea</li><li>Milk</li><li>Milk</li><li>Milk</li><li>Milk</li><li>Milk last</li>";
    text = text.replaceAll("</li>", "");
    String[] results = text.split("<li>");
    // The first one is empty, remove it
    for (int i = 1; i < results.length; i++) {
        System.out.println(results[i]);
    }