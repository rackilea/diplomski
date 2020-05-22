String pathToClassFile = "/home/shackle/somedir/classes/pkg/Test.class";
ProcessBuilder pb = new ProcessBuilder("javap",pathToClassFile);
Process p = pb.start();
String classname = null;
try(BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
   String line;
   while(null != (line = br.readLine())) {
       if(line.startsWith("public class")) {
           classname = line.split(" ")[2];
           break;
       }
   }
}
System.out.println("classname = " + classname);