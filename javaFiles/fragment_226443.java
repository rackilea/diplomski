while(scan.hasNextLine()){                   // <-- hasNextLine()
  String line = scan.nextLine();             // <-- nextLine()
  String[] tempArray = line.split(",");      // <-- split on the comma.

  for (int i=0; i<tempArray.length; i++){    // <-- use the array length
    System.out.println(tempArray[i].trim()); // <-- trim() the String
  }
}