Scanner read = new Scanner(f); 
         //int noOfLines=0;
         while(read.hasNextLine()){
            if(read.nextLine().equals(username)){
              if(read.nextLine().equals(password)){ 
                 grantAccess=true; 
                 read.close();
                 break;
              }
           }
         }