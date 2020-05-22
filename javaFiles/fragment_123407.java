// Create a static BR which you only initialize once
 static BufferedReader br;

// Inside inputOutput
...
private static String inputOutput(BufferedReader br, String message) {
    ....
    if (br == null)
        br = new BufferedReader(new InputStreamReader(System.in));
    ...
}