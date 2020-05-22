Process process = new ProcessBuilder("cmd.exe", "/c", cmd1)
        .redirectErrorStream(true)
        .start();
try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
    for (String line; (line = reader.readLine()) != null; ) {
        System.out.println(line);
    }
}
int exitCode = process.waitFor();