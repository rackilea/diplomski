StringBuffer errors = new StringBuffer();

 @Test
 public void testSomething(){
    if(!"data".equals(text)){
      addErrors(text +"not equal to data");
    }

    // add any number of if statements to check anything else 
 }

 @After()
 public void tearDown(){
   if(errors.length()!=0){         
     Assert.fail(errors.toString());
   } 
 }

 public String addErrors(String message){
   errors = errors.append(message+"\n");
 }