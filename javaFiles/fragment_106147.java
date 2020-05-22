public static void runCommand(final String[] command, final File directory, final File output) throws IOException, InteruptException {
    final ProcessBuilder pb = new ProcessBuiler(command); 
    pb.redirectErrorStream(true); //optional; easier for this case to only handle one stream
    pb.redirectOutput(Redirect.to(output));
    final Process p = pb.start();

    if(p.waitFor != 0) {
        //throw an exception / return error message
    }
}