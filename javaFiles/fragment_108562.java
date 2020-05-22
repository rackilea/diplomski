String[] files = directory.list();
    for(String file : files){
        //Check if the sub-directory/file name starts with J
        if(file.startsWith("J")){
            System.out.println(file);   
            //Do something here
        }

    }