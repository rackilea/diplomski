public void writer() throws Exception {
    PrintWriter out = new PrintWriter("words.txt");
    for (String entry : webster)
        out.println(entry);
    out.close();
}