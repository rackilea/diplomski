int decimalCopy = decimal;
int len = 0;
while (decimal != 0 ) { 
      decimal = decimal / 2;
      len ++;
      decimal = decimalCopy;
}