String directory = "D:\\Soft\\WebApplication\\build\\web\\code\\";
String[] commands = {"cmd", "/C", "gcc", "Demo.c", "-o", "Demo.exe"};

ProcessBuilder pb = new ProcessBuilder();
pb.directory(new File(directory));
pb.command(commands);

Process p = pb.start();

// process in/out streams