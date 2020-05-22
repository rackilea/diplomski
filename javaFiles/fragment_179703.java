public static int reverse(int x){
    int y = x;
    while(y!=0){
        System.out.print(y%10 + "");
        y/=10;
    }
    //System.out.println();
    return x;
}