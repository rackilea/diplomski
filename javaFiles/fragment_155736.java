/** 
    * Randomly sets the colour of the instance variable 
    * light to red, green, or purple.
    */  
   public void changeColour(Circle aCircle)
   {
       int i = getRandomInt(3);
       if (i == 0)
       {
           this.light.setColour(OUColour.RED);
       }
       else if (i == 1)
       {
           this.light.setColour(OUColour.GREEN);
       }
       else
       {
            this.light.setColour(OUColour.PURPLE);
       }
   }