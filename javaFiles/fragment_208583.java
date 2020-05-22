static class FastScanner {
    BufferedReader br;
    StringTokenizer st;

    FastScanner(InputStream f) {
        br = new BufferedReader(new InputStreamReader(f));
    }

    String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }

    int nextInt() throws IOException {
        return Integer.parseInt(next());
    }
}