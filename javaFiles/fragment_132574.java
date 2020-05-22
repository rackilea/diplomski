String path = "/a/b////c";
ArrayList<String> directories = new ArrayList<String>();
Pattern regex = Pattern.compile("[^" + DIRECTORY_PATH_SEPARATOR + "]+");
Matcher matcher = regex.matcher(path);
while (matcher.find())
    directories.add(matcher.group());