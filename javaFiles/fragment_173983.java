import java.util.Scanner;
public class Polynomial {

private int degree;
private int [] coefficient;
private double evaluation; 
private double sum;
Scanner key = new Scanner(System.in);
public Polynomial(int degree)
{
    this.degree = degree;
    coefficient = new int [degree+1];

}

public void setCoefficient(int coefficient, int degree) 
{
    this.coefficient[degree] = coefficient;
}

public int getCoefficient(int degree)
{
    return coefficient[degree];
}

public void Evaluate(double value)
{
    for (int i=0; i<=degree; i++)
    {
        System.out.println("Enter coefficent for position " + i);
        this.coefficient[i] = key.nextInt();
        evaluation = Math.pow(value, i)*this.coefficient[0] ;
        this.sum += evaluation;

    }
}   
public double getSum(){
    return sum;
}

public String toString()
{
    String s = "";
    for (int i=0; i <= degree; i++)
    {
        s += coefficient[i];
        switch (i) {
            case 0:
                s += " + ";
                break;
            case 1:
                s += "x + ";
                break;
            default:
                s += "x^" + i + ((i==degree)?"":" + ");
        }
    }
    return s; 

}

public static void main(String[] args) {

    int degree;
    double sum;
    int coefficient;

    Scanner key = new Scanner(System.in);
    System.out.println("Enter the degree of the polynomial");
    degree=key.nextInt();

    Polynomial fun = new Polynomial(degree);



    fun.Evaluate(3.0);

    System.out.println(" The sum of the polynomial is " + fun.getSum());

    System.out.println(fun);

}

}