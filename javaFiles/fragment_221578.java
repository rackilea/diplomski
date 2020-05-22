String s = "ERR|appLogger|[Manager|Request]RequestFailed[com.package.file]uploading[com.file]";
Pattern pattern = Pattern.compile("\\[([A-Za-z0-9.]+)\\]");
Matcher m = pattern.matcher(s);
if (m.find()) {
    System.out.println(m.group(1)); // com.package.file
}