public static double round(double number,int numberofdecimals){
    int n=1;
    for (int i = 1; i <= numberofdecimals;i++){
        n=n*10;
    }

    double  c =((number - Math.floor(number))*n); // Here c = 66.6666666...
    c= Math.floor(c + 0.5); // Now c is 67.0.

    return (Math.floor(number) + (c/n)); // returns 1.67
}