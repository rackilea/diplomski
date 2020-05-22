String path = "/a/b////c";
String[] split = path.split(DIRECTORY_PATH_SEPARATOR);
ArrayList<String> directories = new ArrayList<String>(split.length);
for (String dir : split)
    if (dir.length() > 0)
        directories.add(dir);