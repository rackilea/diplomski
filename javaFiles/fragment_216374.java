public static String detectUrls(String text) {
    String newText = text
            .replaceAll("(?:https?|ftps?|http?)://[\\w/%.\\-?&=]+",
                    "<a href='$0'>$0</a>").replaceAll(
                    "(www\\.)[\\w/%.\\-?&=]+", "<a href='http://$0'>$0</a>");
    return newText;
}