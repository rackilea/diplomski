@Override
protected Integer doInBackground() {
    BufferedReader in = null;
    try {
        in = new BufferedReader(new FileReader("build.xml"));
        String s;
        try {
            while ((s = in.readLine()) != null) {
                publish(s);
            }
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }
    } catch (FileNotFoundException ex) {
        ex.printStackTrace(System.err);
    } finally {
        try {
            in.close();
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }
    }
    return status;
}