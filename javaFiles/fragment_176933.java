String[] command = new String[3];
command[0] = "CMD.EXE";
command[1] = "/C";
command[2] = "\"C:\\Program Files\\juman\\juman.exe \" -e < "+jhghai_w.filepath;
ProcessBuilder pb = new ProcessBuilder(command);
pb.start();