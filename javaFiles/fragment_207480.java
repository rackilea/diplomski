try{
           int type = Integer.parseInt(selection);
           switch(type){
           case 1:{
            //do soldier stuff   
           }
           case 2:{
            // do knight stuff   
           }
           default:{
               //do other stuff
           }
           }
       }catch(NumberFormatException exc ){
           System.out.println(selection + "is not a number, try again!!!");
       }