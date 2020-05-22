enum E{
 A, B, C...   
}

final static E[] vals = E.values();//copy the values(), calling values() clones the array
boolean f(int variable){
  switch(vals[variable]){
  case A:
...
  case B:
...
//break;
  default:
...
   }
}