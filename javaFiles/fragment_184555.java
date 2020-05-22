try {
           if(DaysNum > 0){
               return DaysNum;
           }
   throw new NegativeException("number is negative");
} catch (NegativeException e) {e.printStackTrace();}