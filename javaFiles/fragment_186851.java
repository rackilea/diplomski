ProcessBuilder   ps=new ProcessBuilder("java.exe","-version");

//From the DOC:  Initially, this property is false, meaning that the 
//standard output and error output of a subprocess are sent to two 
//separate streams
ps.redirectErrorStream(true);

Process pr = ps.start();  

BufferedReader in = new BufferedReader(new InputStreamReader(pr.getInputStream()));
String line;
while ((line = in.readLine()) != null) {
    System.out.println(line);
}
pr.waitFor();
System.out.println("ok!");

in.close();
System.exit(0);