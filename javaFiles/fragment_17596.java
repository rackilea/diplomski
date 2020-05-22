int a, b, c, min, max, med;//assume values are there for a b c
if( a > b ){
 if( a > c ){
  max = a;
  if( b > c ){
   med = b;
   min = c;
  }else{
   med = c;
   min = b;
  }
 }else{
  med = a;
  max = c;
  min = b;
 }
}else{
 if( b > c ){
  max = b;
  if( a > c ){
   med = a;
   min = c;
  }else{
   med = c;
   min = a;
  }
 }else{
  med = b;
  max = c;
  min = a;
 }
}