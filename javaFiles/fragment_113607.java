BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(
        new File(filename)), "UTF-8"));
try {
    out.write(str);
} finally {
    out.close();
}