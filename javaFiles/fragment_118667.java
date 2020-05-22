int countline;
 while(infile.hasNext()) {
     nameslist.add(infile.nextLine());
     countline++;        
 }     
 System.out.println("Number of line: "+ countline);