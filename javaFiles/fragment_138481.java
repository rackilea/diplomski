try {
  BufferedReader input = new BufferedReader(new FileReader("tail.log"));

  while (true) {
    String line;

    while ((line = input.readLine()) != null) {
      //You'll probably want to do something other than println()
      System.out.println(line);
    }

    try {
      Thread.sleep(500);
    } catch (InterruptedException e) {
      break;
    }

  }

  input.close();
 }
 catch (IOException ioe) {
   //Handle this
 }