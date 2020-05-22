FileReader fr = new FileReader(path);
try {
    BufferedReader br = new BufferedReader(fr);
    return br.readLine();
} finally {
    fr.close();
}