String str = fileEntry.getName();
if (str == null || "index.html".equals(str)) {
    continue;
}
if (str.length() >= 33 && str.charAt(32) == '9') {
    arrayList.add(str);
}