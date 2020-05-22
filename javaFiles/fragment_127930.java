public static String cutString(String target, String pattern) {
    if (target.contains(pattern)) {
        return target.split(pattern)[1].substring(0, target.split(pattern)[1].indexOf('&'));
    }
    return target;
}