private String getFruitsPrefMsg() {

   String message = getMessage();
   if(message == null)
       message = getOtherMessage();

   try {
      switch(FruitsType.valueOf(message)) {
          case Apple:
              //return something
          case Orange:
              //return something
          case Mango:
              //return something
      }
   } catch(IllegalArgumentException exception) {
        //Message is not in the enum.
        //Handle error
        //You can return something here
   }

   //Or return something here
}