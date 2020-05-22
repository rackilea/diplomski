public static String getCurrentGitBranch() throws IOException, InterruptedException {
    Process process = Runtime.getRuntime().exec( "git rev-parse --abbrev-ref HEAD" );
    process.waitFor();

    BufferedReader reader = new BufferedReader(
            new InputStreamReader( process.getInputStream() ) );

    return reader.readLine();
}