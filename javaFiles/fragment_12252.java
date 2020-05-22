String myFile = "some filename.txt";
ProcessBuilder builder = new ProcessBuilder(
    "cp", "-R", myFile,        // We handle word splitting
       System.getenv("HOME")); // We handle variables
builder.redirectError(         // We set up redirections
    ProcessBuilder.Redirect.to(new File("errorlog")));
builder.start();