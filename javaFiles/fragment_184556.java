try {
           if(DaysNum > 0){
               return DaysNum;
           }
          throw new IllegalArgumentException("number is negative");
} catch (IllegalArgumentException e) {e.printStackTrace();}