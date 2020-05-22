public static List<String> tokenize(String s) throws IOException {
    List<String> opts = new ArrayList<String>();
    StreamTokenizer st = new StreamTokenizer(new StringReader(s));
    st.quoteChar('\"');
    while (st.nextToken() != StreamTokenizer.TT_EOF) {
        opts.add(st.sval);
    }

    return opts;
}