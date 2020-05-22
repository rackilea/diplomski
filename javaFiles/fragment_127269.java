// (Using same example even though it doesn't matter here - imaging a Writer)
FileReader fr = new FileReader(path);
try {
    BufferedReader br = new BufferedReader(fr);
    try {
        return br.readLine();
    } finally {
        br.close();
    }
} finally {
    fr.close();
}