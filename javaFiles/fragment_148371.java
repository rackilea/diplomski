private int digit(int val,int dig){
    int div = 1;
    for(int i=0;i<dig;i++)
        div*=10; //make 10^dig
    val/=div; //remove the smaller digits
    return val%10; //return only one digit
}