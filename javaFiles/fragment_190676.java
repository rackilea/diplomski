do {

       rem=decimal%16; 
       hexstring=hex[rem]+hexstring; 
       decimal=decimal/16;

     }while (decimal > 0);