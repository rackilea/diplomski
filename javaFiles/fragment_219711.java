// Users of your code invoke this method
public static boolean isPrime(int num) {
    return isPrime(num, num);
}
// This overload with two parameters is the actual recursive method
private static boolean isPrime(int num, int original) {
    if(original%(int)((num--/2)+0.5)==0)
        return false;
    }

    else{
        if(num==1)
            return true;
        else
            return isPrime(num, original);
    }
}