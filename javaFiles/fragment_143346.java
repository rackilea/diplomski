public double TempConvert(double temp,char scale) {
    if (scale=='c') 
        return (9.0/5.0)*temp+32;
    if (scale=='f')
        return (temp-32)*(5.0/9.0);
    return -1;
}