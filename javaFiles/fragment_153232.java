public static int num(int n){
    if(n <= 0)
        return 2;
    else
        return (2 * num(n-1))+1; //Recursive call here
}