Path parentDirectory = Paths.get("Users","Documents","Uni","Music Player","src","Common");
String sqlCommand = "sqlite3 database.db"; 
File inputSqlFile = new File("database.sql");        

Process process = new ProcessBuilder()
        .directory(parentDirectory.toFile())
        .command(sqlCommand)
        .redirectInput(Redirect.from(inputSqlFile))
        .start();