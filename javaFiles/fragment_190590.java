if(ob.date.matches(REG_EX_FULLDATE)){
      // use dateFormatter1
  }
 else if(ob.date.matches(REG_EX_SHORTDATE)){
     // use dateFormatter2
 } else {
       throw new RuntimeException();
 }