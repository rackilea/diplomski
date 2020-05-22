public static void main(String[] args)
{
    List<ExampleClass> list = new ArrayList<ExampleClass>();

    ExampleClass ec1 = new ExampleClass(1);

    list.add(ec1);
    list.add(new ExampleClass(3));
    list.add(new ExampleClass(102));

    System.out.println(list.indexOf(new ExampleClass(3)));
    System.out.println(list.indexOf(new ExampleClass(1)));
    System.out.println(list.indexOf(ec1));
    System.out.println(list.indexOf(new ExampleClass(5)));

}