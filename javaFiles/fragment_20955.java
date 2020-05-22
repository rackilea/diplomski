int sum = uno + dos + tres + cuatro;
double pru = sum*8;
String tot1 = "";
if(sum == 11){
    double tot = pru - (pru*.01);
    tot1 = String.valueOf(tot);
}
print tot1;