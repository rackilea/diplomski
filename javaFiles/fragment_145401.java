String line;
  PrintWriter out= new PrintWriter(new FileWriter("D:\\outputfile.txt"));

  while ((line = br.readLine()) != null) {  
      out.println(line);
  }