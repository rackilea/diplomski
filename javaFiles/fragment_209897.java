try {

             price = Double.parseDouble(tokens[3]);
             if (price <0)
                 throw new NumberFormatException();

         }catch (NumberFormatException n){

             price = 0.0;
         }




   try {

             count = Integer.parseInt(tokens[4]);
             if(count <0) 
                 throw new NumberFormatException();

         }catch (NumberFormatException n){

             count = 0;
         }