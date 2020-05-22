try
 {
    if(list.isEmpty()) {
         // What exception to throw here?
         // It means there was a name in the file (first line) but then no csv values 
          throw new CheckListException();
    }
 }
 catch(CheckListException ex)
 {
      //Process message however you would like
 }