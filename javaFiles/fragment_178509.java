public static int GetPower(int base, int power){
 long result = 1;

 for(int i = 1; i <= power; i++)
 {
    result *= base;
    if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
        return -1;
    }
 }
 return result;
}