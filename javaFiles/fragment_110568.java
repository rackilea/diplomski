try{  
     FileWriter fw=new FileWriter(filename);  
     for (String words : arrayToWrite) {
        fw.write(words + "\n");
     } 
     fw.close(); 

   }catch(Exception e){
     System.out.println(e);
}