Date tempDate = new Date(1403685556000L);    // first reference.
    Test test = new Test();                  
    test.setDate(tempDate);                      
    tempDate = new Date(1435221556000L);         // second reference.
    Date abc = test.getDate();                   // you take the first reference since you do not set "tempDate" in Test before.
    Long def = abc.getTime();
    System.out.println("Date 1:"+def.toString()); // you print the first reference.
    test.setDate(tempDate);                       // you set the second reference and overwrite the first one.
    def = abc.getTime();                          // but "abc" still points on first reference.
    System.out.println("Date 2:"+def.toString());