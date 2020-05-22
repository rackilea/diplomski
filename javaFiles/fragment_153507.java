private  String starString(int n){          
  String temp = "*";

  //only recurse as long as n > 0, i.e. the last invocation would be made with n = 0
  if (n > 0){ 
    temp += starString(n-1);                     
  }                      
  return temp;       
}