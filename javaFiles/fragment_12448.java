Pattern p = Pattern.compile("^T\\.methodA\\(['\"]?(.+?)['\"]?\\)\\.methodB\\(['\"]?([^,]+?)['\"]?,['\"]?(.+?)['\"]?\\)\\.methodC\\(['\"]?(.+?)['\"]?\\)$");

Matcher m = p.matcher(inputSctipt);
if (m.find()) {
    System.out.println("With regexp:\n" + m.group(1));
}