public static void exportList(ListModel model, File f) throws IOException {
    PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(f), "UTF-8"));
    try {
        int len = model.getSize();
        for (int i = 0; i < len; i++) {
            pw.println(model.getElementAt(i).toString());
        }
    } finally {
        pw.close();
    }
}