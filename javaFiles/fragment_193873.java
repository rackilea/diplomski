File inputFile = new File("C:\\file.txt");
    Scanner scan = new Scanner(inputFile);
    String size = scan.nextLine(); // read size
    String aux = scan.nextLine(); 
    aux = aux.replaceAll("\\s",""); // remove whitespaces for better Integer.parseInt(String)
    String[] parts = aux.split(","); 
    System.out.println("size "+size);
    for (int i = 0; i < parts.length; i++) { 
       System.out.println(parts[i]);
    }
    scan.close();