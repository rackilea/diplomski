BufferedReader stdInput = new BufferedReader(new 
     InputStreamReader(p.getInputStream()));

BufferedReader stdError = new BufferedReader(new 
     InputStreamReader(p.getErrorStream()));

// read the output from the command
System.out.println("Here is the standard output of the command:\n");
String s = null;
while ((s = stdInput.readLine()) != null) {
    System.out.println(s);
}