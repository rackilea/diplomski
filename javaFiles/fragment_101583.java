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
try{
A a=new A();
}
catch(Exception e)
{
System.out.println("caught  "+e);
}

}
}