public static void main(String... args) throws IOException, UnsupportedFlavorException {
    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    String path = readAsString(clipboard);
    path = path == null ? readAsFileList(clipboard) : path;
}

private static String readAsFileList(Clipboard clipboard) {
    try {
        List<String> paths = (List<String>)clipboard.getData(DataFlavor.javaFileListFlavor);
        return paths.isEmpty() ? null : paths.iterator().next();
    } catch(Exception e) {
        e.printStackTrace();
        return null;
    }
}

private static String readAsString(Clipboard clipboard) {
    try {
        return (String)clipboard.getData(DataFlavor.stringFlavor);
    } catch(Exception e) {
        e.printStackTrace();
        return null;
    }
}