final List<String> command = Arrays.asList(
    "7za", "x", "-o", tempFolder, sourceStr
);

final ProcessBuilder pb = new ProcessBuilder(command).inheritIO();

final int retcode = pb.start().waitFor();