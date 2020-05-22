String[] aaa = line.split(" ");
     String newLine = "";                                  
     if(aaa[0].equals("0"))
     for(int i =0; i < aaa.length; i++)
     newLine += aaa[i]+' ';
     newLine += '\n';                                       
     writer.write(newLine);  


    }