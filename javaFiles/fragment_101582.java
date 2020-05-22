class A 
{
public  A() throws Exception
{
int k=5/0;
}

}

public class B 
{
public static void main(String[] args)
{
A a=new A();
}
}