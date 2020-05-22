String[] prefixes = new String[]{"video", "audio", "images"};
String[] contains = new String[]{"zip", "rar", "x-tar", "jar-archive"};
boolean match = false;
for (String p : prefixes) {
    if (filetype.startsWith(p)) {
        match = true;
    }
}
...
if (!match) {
    // do stuff
}