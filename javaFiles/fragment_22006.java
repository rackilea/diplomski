File file = new File("file path"); 

  BufferedReader br = new BufferedReader(new FileReader(file)); 

  String st; 
  while ((st = br.readLine()) != null) 
    System.out.println(st); 
  }