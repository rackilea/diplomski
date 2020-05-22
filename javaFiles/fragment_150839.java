public long amountmoney (long days){

if(days<=1){

return 1;}

else{

return 2*amountmoney (days-1);}

}