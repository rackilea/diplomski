public static String isolateTumblrCodeFromURL(String url) {
    int start = url.indexOf("tumblr_");
    if (start == -1) return null;
    int end = url.indexOf('&', start);
    if (end == -1) return null;
    return url.substring(start, end);
}