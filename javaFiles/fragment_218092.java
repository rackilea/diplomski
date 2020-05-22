public class MyClass
{
  .....

  @Override
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("Name: " + name);
    sb.append(System.lineSeparator());
    sb.append("Surname: " + surname);
    return (sb.toString());
  }

  public void printAge(PrintStream stream)
  {
    stream.println("Age: " + age);
  }

} // class MyClass

...
MyClass my_instance;
my_instance = new MyClass();
...
System.out.println(my_instance);
System.out.flush() // make sure everything's printed before doing something on stderr
my_instance.printAge(System.err);
System.err.flush() // make sure everything's printed before doing something on stdout again
System.out.println("Anything else to print");
...