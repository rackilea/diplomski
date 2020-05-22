public List<File> search(File root, int id) {
    List<File> found = new ArrayList<File>();
    if (root.isFile() && root.getName().endsWith("_" + id + ".xml")) {
        found.add(root);
    } else if (root.isDirectory() && !root.getName().contains("svn")) {
        for (File file : root.listFiles()) {
            found.addAll(search(file, id));
        }
    }
    return found;
}