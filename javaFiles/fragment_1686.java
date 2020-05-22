int lines = 0;
while(inFile.hasNextLine())
  {
    token = inFile.nextLine(); 
    lines++ ;
  }
System.out.print(lines);