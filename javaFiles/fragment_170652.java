//Here i got the idea.
public static void main(String[] args) {
    // Let the number be 139.
    int n=139;
    System.out.println("reverse is "+rev(n));
}
static int rev(int n){
    if (n<10)return n;
    else return n%10*(int) Math.pow(10,(int)Math.log10(n))+rev(n/10);
        //Math class is used to return the number of digits and power.
}