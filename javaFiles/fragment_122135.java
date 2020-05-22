private double myMethod() { 
double result=0; 
if(myArrayList.size() >= 2) { 
    double t = myArrayList.get(myArrayList.size()-1); 
    double d = myArrayList.get(myArrayList.size()-2); 
    result = ( t+ d ) / 2 ; 
    System.out.println("Average is: "+result); 
} 
return result;