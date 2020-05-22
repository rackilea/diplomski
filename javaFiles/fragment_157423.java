public void AverageMarks(String fName, String pname) {

    BufferedReader br = null;
    try{ 
         br = new BufferedReader(new FileReader(fName));
        }catch(FileNotFoundException e){
        System.out.println("Could not find file");
    }

    try{    
        double average = 0;
        double sum = 0;
        String line;

        while((line = br.readLine()) != null){
          String[] lines = line.split(" ");

          if(pname.equals(lines[0])){
            if(lines.length > 1) { // check to calculate average only when there are numbers as well in the line
              for(int i = 1; i<lines.length; i++){ // loop index shold start from 1 as element at index 0 is name
                sum+= Double.parseDouble(lines[i]);
              }

              average = sum / (lines.length - 1);
            }
            System.out.println(average);
            System.exit(0);
          }
        }

        // moved these lines from inside loop, to make sure all the names in the files have been checked
        System.out.println(pname + " No such name");
        System.exit(0);

    }catch(IOException e){
        System.out.println("An error has occured");
    }
    finally{
        System.exit(0);
    }
  }