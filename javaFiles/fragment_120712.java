final Path basePath = Paths.get("C:\\dir1\\dir2\\dir3");

final Process compileProcess = new ProcessBuilder("javac", "Main.java")
    .directory(basePath.toFile())
    // other niceties of ProcessBuilder
    .start();

// check the status of the process; rinse, repeat