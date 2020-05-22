public static long performBackTrack(char op,long res,long num1) {
//trying to restore numbers
    switch(op){
        case '+':return res - num1;
        case '-':return num1 - res;
        case '*':return res / num1;
        default:return 0L;
    }
}