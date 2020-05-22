public static void main(String[] args) {
    ...
    ph.parse(p, getAntXML()};
    ...
}

private Object getAntXML() throws IOException {
    InputStream inputStream = null;
    OutputStream outputStream = null;
    try {
        inputStream = this.getClass().getResourceAsStream("/report.xml");
        File f = File.createTempFile("report", "xml");
        outputStream = new FileOutputStream(f);
        int read;
        byte[] bytes = new byte[1024];

        while ((read = inputStream.read(bytes)) != -1) {
            outputStream.write(bytes, 0, read);
        }
        return f;
    } catch (IOException ex) {
        throw ex;
    } finally {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                //Nop
            }
        }
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e) {
                //Nop
            }

        }
    }
}