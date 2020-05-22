public static void main (String[] args)
{
 int a,b,c;
 a=10;
 b=15;
 c=20;
 int d= gcd(a,b,c);
 System.out.println("The GCD of "+a+", "+b+" and "+c+ " is "+d);
 int cake=a/d+b/d+c/d;
 System.out.println("So the cake is divided into "+ cake);
 System.out.println("The "+a+ " Years old get "+a/d );
 System.out.println("The "+b+ " Years old get "+b/d );
 System.out.println("The "+c+ " Years old get "+c/d );
}

public static int gcd(int a, int b, int c){
 return calculateGcd(calculateGcd(a, b), c);
}

public static int calculateGcd(int a, int b) {
    if (a == 0) return b;
    if (b == 0) return a;
    if (a > b) return calculateGcd(b, a % b);
    return calculateGcd(a, b % a);
 }
}