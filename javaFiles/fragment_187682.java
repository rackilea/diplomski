String str = null;
    BufferedReader r = new BufferedReader(new FileReader("filename", "UTF-8"));
    try {
        StringBuilder sb =
             new StringBuilder(/* approx size of file in CHARACTERS */);
        int ch;
        while ((ch = r.read()) != -1) {
            sb.append((char) ch);
        }
        str = sb.toString();
    } finally {
        r.close();
    }