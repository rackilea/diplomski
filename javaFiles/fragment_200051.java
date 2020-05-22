FileReader fr = new FileReader(fileName);
Closeable res = fr;
try {
    BufferedReader br = new BufferedReader(fr);
    res = br;
} finally {
    res.close();
}