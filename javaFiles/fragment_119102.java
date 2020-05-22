Map<String, String> placeHolderMap = new HashMap<>();
    placeHolderMap.put("\\$\\{name}", "device");
    placeHolderMap.put("\\$\\{status}", "broken");
    placeHolderMap.put("\\$\\{title}", "smartphone");


    // input String
    String content = "This ${name} is ${status} and categorized as ${title} in the system";

    for (Map.Entry<String, String> entry : placeHolderMap.entrySet()) {
          content = content.replaceAll(entry.getKey(), entry.getValue());
    }