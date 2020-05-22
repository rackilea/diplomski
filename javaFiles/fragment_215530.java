public void method1()
{
    System.out.println("The answer is: 42");
}

public void method2(int value)
{
    System.out.println((new StringBuilder("The answer is: ")).append(value).toString());
}

public void method3(int value)
{
    String a = (new StringBuilder("The answer is: ")).append(value).toString();
    System.out.println((new StringBuilder(String.valueOf(a))).append(" what is the question ?").toString());
}