String first= "test";
    WordUtils.capitalize(first); 
   //Above method returns a new String,you are not receiving that

    // Still first is "test" because String is immutable.
     first= WordUtils.capitalize(first);  
    //Now  first  = "TEST"