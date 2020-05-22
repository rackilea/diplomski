import java.util.Scanner;
/*Data Abstraction Using interface */
interface Operation
{
int sum();
int mul();
int sub();
int div();
}

/* Or Using Abstract Class

abstract class Operation
{
    abstract int sum();
    abstract int mul();
    abstract int sub();
    abstract int div();
}
class Algebra extends Operation  (Inheritance)
{
    code..
}
*/

class Algebra implements Operation 
{
private int number1,number2;
Algebra()
{
    number1=0;
    number2=0;
}
    Algebra(int number1,int number2)
    {
        this.number1=number1;
        this.number2=number2;
    }

    /* Encapsulation of the Data Memebers and Functions*/
        public int sum()
        {
            return number1+number2;
        }
        public int mul()
        {
            return number1*number2;
        }
        public int div()
        {
            return number1/number2;
        }
        public int sub()
        {
            return number1-number2;
        }
}
class Test 
{
public static void main(String [] args)
{
    int number1,number2;
    char choice;
    Scanner input=new Scanner(System.in);
    Algebra A=new Algebra(); //Dynamic Object of Sub Class
    Operation Op; //Static Object
    Op=(Algebra)A; //Type Casting of the Static Object of interface or abstract class
    System.out.println("Enter the number 1 : ");
    number1=input.nextInt();
    System.out.println("Enter the numbre 2 : ");
    number2=input.nextInt();
    System.out.println("Enter choice : 1.)Sum 2.)Mul 3.)Div 4.)Sub ");
    choice=input.next().charAt(0);
    Op=new Algebra(number1,number2);


        switch(choice)
        {
            case '1':
            System.out.println("Sum is : "+Op.sum());
            break;
            case '2':
            System.out.println("Mul is : "+Op.mul());
            break;
            case '3':
            System.out.println("Div is : "+Op.div());
            break;
            case '4':
            System.out.println("Sub us : "+Op.sub());
            break;
        }
}
}