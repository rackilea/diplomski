if(amount >= 100){
     tmp = (int) amount/100;         
     if(tmp > 1.0){
         System.out.println (tmp + "$100 bills");
     } else{
         System.out.println (tmp + "$100 bill");
     }
     amount = amount % 100;
 }