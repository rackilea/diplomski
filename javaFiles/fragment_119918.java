class Num 
{
    Num(double x) 
    { 
        System.out.println( x ) ; 
    }
}

class Number extends Num 
{ 


 Number(double x){
 super(x);
 }

 public static void main(String[] args)
    { 
        Num num = new Num(2) ; 
    } 
}