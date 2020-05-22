final String[] hwdebug1 = {"su","-c","echo hello > /system/hello1.txt"};
final String[] hwdebug2 = {"su","-c","echo hello > /system/hello2.txt"};
final String[] hwdebug3 = {"su","-c","echo hello > /system/hello3.txt"};
ArrayList<String[]> cmds = new ArrayList<String[]>();
cmds.add(hwdebug1);
cmds.add(hwdebug2);
cmds.add(hwdebug3);
for(String[] cmd:cmds){
    try {
       Runtime.getRuntime().exec(cmd);              
   } catch (IOException e) {
       e.printStacktrace(); 
   }          
}