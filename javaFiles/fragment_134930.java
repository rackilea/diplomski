public static void myFormat(double number){
    String sign = "";
    if (number < 0) { sign = "-";}

    int decimalPart, wholePart;

    if(number == (int)number){ // number is an integer
        System.out.println( (int)number+".000");
    }
    else { // number has some decimal components
        int myNewNum = (int)(number * 1000); // get the portions we need
        decimalPart = myNewNum - ( (int)number * 1000 );
        wholePart = (myNewNum - decimalPart) / 1000;

        //make whole and decimal part positive for formatting purposes
        if (decimalPart < 0) { decimalPart *= -1; }    
        if (wholePart < 0) { wholePart *= -1;}

        System.out.println(sign + wholePart + "." + decimalPart);
    }
}