Path databasePath = FileSystems.getDefault().getPath("Users", "Documents", "Uni", "Music Player", "src", "Common", "database.db");
Path sqlPath = FileSystems.getDefault().getPath("Users", "Documents", "Uni", "Music Player", "src", "Common", "database.sql");

File database = databasePath.toFile().getAbsoluteFile();
File sqlFile = sqlPath.toFile().getAbsoluteFile();

System.out.println("Database location:\n\t" + database.getCanonicalPath());
System.out.println("SQL file location:\n\t" + sqlFile.getCanonicalPath());

assert database.exists() && database.isFile() && database.canRead() && database.canWrite(): "No such database file!";
assert sqlFile.exists() && sqlFile.isFile() && database.canRead() : "No such SQL file!";

String[] sqlCommand = {"sqlite3", database.getCanonicalPath()};
Redirect sqlInput = Redirect.from(sqlFile);
File workingDirectory = database.getParentFile().getCanonicalFile();

System.out.println("Running this command:\n\t" +
sqlCommand[0] + sqlCommand[1] + "<" + sqlInput.file().getCanonicalPath());

Process process = new ProcessBuilder()
        .directory(workingDirectory)
        .command(sqlCommand)
        .redirectInput(sqlInput)
        .start();