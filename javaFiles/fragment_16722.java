while(inFile.hasNextLine()){
        token[counter] = inFile.nextLine();
        tokenElements = token[counter].split("  ");
        counter++;

        for(String part:tokenElements){
            System.out.println(part);
        }
   }