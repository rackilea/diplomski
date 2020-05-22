try {

      File file = new File("H:\\eclipse\\New folder\\Testing_Project\\WebContent\\");

      if (file.createNewFile()){
        System.out.println("File is created!");
      }else{
        System.out.println("File already exists.");
      }

    } catch (IOException e) {
      e.printStackTrace();