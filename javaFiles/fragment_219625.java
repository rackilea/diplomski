File database = FileSystems.getDefault()
    .getPath("Users", "Documents", "Uni","Music Player", "src", "Common", "database.db")
    .toFile().getAbsoluteFile();
File sqlFile = FileSystems.getDefault()
    .getPath("Users", "Documents", "Uni","Music Player", "src", "Common", "database.sql")
    .toFile().getAbsoluteFile();

String[] sqlCommand = {"sqlite3", database.getCanonicalPath()};
Redirect sqlInput = Redirect.from(sqlFile);
File workingDirectory = database.getParentFile().getCanonicalFile();

Process process = new ProcessBuilder()
        .directory(workingDirectory)
        .command(sqlCommand)
        .redirectInput(sqlInput)
        .start();