File file = new File("fileName");

  Scanner scannerFile = new Scanner(file);

 while(scannerFile.hasNextLine()){
        String line = scannerFile.nextLine();
        String[] lineVector = line.split(",");

  }