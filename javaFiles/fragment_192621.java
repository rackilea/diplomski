private static void traverse(File dir){
    if (dir.isDirectory()) {
        String[] children = dir.list();
        for (int i = 0; children != null && i < children.length; i++) {
            traverse(new File(dir, children[i]));
        }
    }
    if (dir.isFile()) {
        if (dir.getName().endsWith(".zip")
                || dir.getName().endsWith(".xml")) {
            System.out.println(dir.getAbsolutePath());//change it if needed
        }
    }
}