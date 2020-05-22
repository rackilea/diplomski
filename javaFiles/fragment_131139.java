byte a= 10 ;
float b= 16.3 ;
int c= 34 ;
Object o= a * b + c ;
o.getClass();    //  Should be Double or one of the primitive wrapper classes in the general case
//  You can easily convert this to double.class through an if/elseif sequence
//  or a Map.