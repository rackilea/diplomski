BufferedReader br = new BufferedReader(new FileReader("file.txt"));

try {
    return br.readLine();
} finally {
    br.close();
}