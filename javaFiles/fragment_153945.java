public static int pmove() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String br_rl = br.readLine();
    int br_int = Integer.parseInt(br_rl);
    if (br_int > 0 && br_int < 10) {
        return br_int;
    } else {
        throw new IOException("Input Out of Range");
    }
}