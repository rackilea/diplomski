public static void main(String... args) {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while ((line = in.readLine()) != null) {
        String[] words = line.split(" "); // this could be done more robustly

        String arg1 = words[0];
        String arg2 = words[1];
        String arg3 = words[2];
        String arg4 = words[3];
        int arg5 = Integer.parseInt(words[4]);
        int arg6 = Integer.parseInt(words[5]);
        int arg7 = Integer.parseInt(words[6]);

        // then carry on as before
    }
}