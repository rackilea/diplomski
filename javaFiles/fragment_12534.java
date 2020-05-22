InputStream stream = new FileInputStream("myfile");
try {
    Reader reader = new InputStreamReader(stream, "UTF-8"); // or another encoding
    try {
        BufferedInputStream in = new BufferedInputStream(reader);
        try {
            String line = in.readLine();
            while (line != null) {
                String[] fields = line.split("[\\t]");
                if (fields.length == 3) {
                    addToMap(new Games(fields[0]), new LocalStores(fields[1]), Integer.parseInt(fields[2]));
                }
                line = in.readLine();
            }
        } finally {
            in.close();
        }
    } finally {
        reader.close();
    }
} finally {
    stream.close();
}