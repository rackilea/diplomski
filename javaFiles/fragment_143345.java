public double TempConvert(double temp,char scale) {
    if (scale=='c') // the current temp is in Celsius
        return ((temp*9)/5)+32; // fixed for order of operations
    if (scale=='f') // the current temp is in Fahrenheit
        return ((temp-32)*5)/9; // fixed for order of operations
    return -1; // incorrect char selected
}