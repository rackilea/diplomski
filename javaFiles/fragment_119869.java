String cursorManufacturer = cursor.getString(0);
        boolean matchFound = false;

        //Checking for manufacturer in the list
        for(String manufacturerInList:manufacturerList){
            if (manufacturerInList.equals(cursorManufacturer)){
                 matchFound = true;
                 break;
            }
        }                   
        if(!matchFound){ // <- doesn't exit in the list
            manufacturerList.add(cursorManufacturer); 
        }