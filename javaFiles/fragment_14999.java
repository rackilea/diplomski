File theDir = new File("new folder");

// if the directory does not exist, create it
if (!theDir.exists()) {
    System.out.println("creating directory: " + theDir.getName());
    boolean result = false;

    try{
        theDir.mkdir();
        result = true;
    } 
    catch(SecurityException se){
        //handle it
    }        
    if(result) {    
        System.out.println("DIR created");  
    }
}