Scanner scan=new Scanner(file);

 while (scan.hasNextLine()) {
     String line = scan.nextLine();

     if (line.equals("a")) {
        answers[0] = answers[0]++;
     } else if (line.equals("b")) {
        answers[1] = answers[1]++;
     } else if (...) {
        // ...
     }      
  }