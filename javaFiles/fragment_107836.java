Runtime rt = Runtime.getRuntime();
String[] processCommand = { "cmd", "/c", "c:" + File.separatorChar + "dir with spaces" + File.separatorChar + "test.bat" };

System.out.println("xPATH: " + processCommand[2]);

Process p = rt.exec(processCommand);
// output of the command is as expected