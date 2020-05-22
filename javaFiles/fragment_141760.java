public static void main(String args[]) {
    int num1 = 0;
    int num2 = 0;
    int num3 = 0;
    int num4 = 0;
    int num5 = 0;
    int tNum1 = 5;
    int tNum2 = 6;
    int tNum3 = 3;
    int tNum4 = 4;
    int tNum5 = 2;
    num5 = tNum1;
    if (tNum2 < num5){
        num4 = tNum2;
    } else {
        num4 = num5;
        num5 = tNum2;
    }
    if (tNum3 < num4){
        num3 = tNum3;
    } else if (tNum3 < num5) {
        num3 = num4;
        num4 = tNum3;
    } else {
        num3 = num4;
        num4 = num5;
        num5 = tNum3;
    }
    if (tNum4 < num3){
        num2 = tNum4;
    } else if (tNum4 < num4){
        num2 = num3;
        num3 = tNum4;
    } else if (tNum4 < num5){
        num2 = num3;
        num3 = num4;
        num4 = tNum4;            
    } else {
        num2 = num3;
        num3 = num4;
        num4 = num5;
        num5 = tNum4;
    }
    if (tNum5 < num2){
        num1 = tNum5;
    } else if (tNum5 < num3){
        num1 = num2;
        num2 = tNum5;            
    } else if (tNum5 < num4){
        num1 = num2;
        num2 = num3;
        num3 = tNum5;
    } else if (tNum5 < num5){
        num1 = num2;
        num2 = num3;
        num3 = num4;
        num4 = tNum5;
    } else {
        num1 = num2;
        num2 = num3;
        num3 = num4;
        num4 = num5;
        num5 = tNum5;                 
    }
    System.out.println(num1);
    System.out.println(num2);
    System.out.println(num3);
    System.out.println(num4);
    System.out.println(num5);
}