b = line.split(";");
if(b.length() < 5){
   System.err.println("Warning, line has only " + b.length() + 
                      "entries, so skipping it:\n" + line);
   continue;
}