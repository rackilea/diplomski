...
try {
    ins = new BufferedReader ( new InputStreamReader(new FileInputStream(file1)));
    while ((line = ins.readLine()) != null) {
        str += line + " ";
    }
} catch (IOException e) {
    e.printStackTrace();
}
...