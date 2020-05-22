public void writer() throws Exception {
    PrintWriter out = new PrintWriter("words.txt");
    Iterator<String> iter = webster.iterator();
    while (iter.hasNext()) {
        out.println(iter.next());
    }
    out.close();
}