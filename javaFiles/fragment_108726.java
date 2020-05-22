String cmd = getDir();
File cmdFile = new File(cmd);
// Maybe check that the cmdFile.exists...;)
File parentFile = cmdFile.getParentFile();

ProcessBuilder pb = new ProcessBuilder(cmd);
pb.directory(parentFile);
pb.redirectError();

Process p = pb.start();