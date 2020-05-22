String command = "generator.out";
String arg1    = "sample.da";
String arg2    = "out.bn";
java.io.File workinDir = new java.io.File("/tmp");
ProcessBuilder pb = new ProcessBuilder(command, arg1, arg2);
pb.directory(workinDir);
Process p = pb.start();