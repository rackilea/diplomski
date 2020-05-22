public static String getParentName(File file) {
    if(file == null || file.isDirectory()) {
            return null;
    }
    String parent = file.getParent();
    parent = parent.substring(parent.lastIndexOf("\\") + 1, parent.length());
    return parent;      
}