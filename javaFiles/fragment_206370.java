Scanner read = new Scanner(f); 
         int noOfLines=0;
         while(read.hasNextLine()){
               read.nextLine();
               noOfLines++;
         }
         read.close();
         read = new Scanner(f); 
        for(int i=0; i<noOfLines; i++){
           if(read.nextLine().equals(username)){
              i++;
              if(read.nextLine().equals(password)){ 
                 grantAccess=true; 
                 read.close();
                 break;
              }
           }
        }