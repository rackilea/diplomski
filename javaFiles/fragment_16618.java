String line;
PrintStream out = null;
BufferedReader br = null;
try {
  out = new PrintStream(new FileOutputStream(outputFile)); 
  br = new BufferedReader(new FileReader(inputFile)); 
  while((line=br.readLine())!=null){
    if(line.trim().isEmpty()) {            
        out.println("proc_online_system_id");   //print what you want here, BEFORE printing the current line         
    }
    out.println(line);        //always print the current line
  }

} catch (IOException e) {
    System.err.println(e);
} finally { 
  try{
    out.close(); 
    br.close();
  } catch (Exception ex) {
    System.err.println(ex);
  }
}