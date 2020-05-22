List<String> listOfDirectories = new ArrayList<String>();
listOfDirectories.add("/home/user/tmp/test");
listOfDirectories.add("/home/user");
listOfDirectories.add("/tmp");
listOfDirectories.add("/etc/test");
listOfDirectories.add("/etc/another");

List<String> result = new ArrayList<String>();

for (int i = 0; i < listOfDirectories.size(); i++) {
    File current = new File(listOfDirectories.get(i));
    File parent = current;
    while ((parent = parent.getParentFile()) != null) {
        if (listOfDirectories.contains(parent.getAbsolutePath())) {
            current = parent;
        }
    }
    String absolutePath = current.getAbsolutePath();
    if (!result.contains(absolutePath)) {
        result.add(absolutePath);
    }
}

System.out.println(result);