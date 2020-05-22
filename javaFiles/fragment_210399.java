Scanner reader = new Scanner(System.in);

      do {
          System.out.println("Enter a file name:");
      } while(!processFile(reader.next())); //Read the file name

      reader.close();


   /**
     * @return true if file read with success otherwise false.
     */
    private boolean processFile(String fileName) {

        try {
            //read the file
        }catch(Exception e) {
            return false;
        }
        return true;

    }