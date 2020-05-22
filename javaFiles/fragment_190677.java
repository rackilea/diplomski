int dec = decimal;
do {

       rem=decimal%16; 
       hexstring=hex[rem]+hexstring; 
       dec/= 16;

     }while (dec> 0);