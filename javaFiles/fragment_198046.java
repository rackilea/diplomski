if(arrayA.size() == arrayB.size()){
//do nothing
}
else{
exit; //array sizes are mismatched and will cause OutOfBounds exception
}

for(int i = 0; i < arrayA.size(); i++){
arrayB[i] = arrayA[i]*GPAConditional; /*GPAConditional is the constant conversion factor used to convert grades into GPA, ultimately defined by you*/ 
}