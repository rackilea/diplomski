private String getUrl(String fileContent) {
    fileContent = fileContent.trim();
    String[] contentList = fileContent.split("\r\n");
    for (String content : contentList) {
        if (content.toUpperCase().startsWith("URL")) {
            int i = content.indexOf("=");
            return content.substring(i + 1);
        }
    }