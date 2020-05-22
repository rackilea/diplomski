ProcessBuilder processBuilder = new ProcessBuilder("cat")
        .redirectError(new File("error"))
        .redirectOutput(new File("output"));

Process process = processBuilder.start();

// process.waitFor();
if (!process.waitFor(3, TimeUnit.SECONDS)) {
    System.out.println("Destroy");
    process.destroy();
}

System.out.println(FileUtils.readFileToString(new File("output")));
System.out.println(FileUtils.readFileToString(new File("error")));