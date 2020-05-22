public class Tester { public static void main (String[] args)

    {
    MyString hello = new MyString("hello");
    System.out.println(hello.getOneString());
    System.out.println(hello.getOneString().charAt(0)); 
    char[] arr = {'g','o','o','d','b','y','e' };
    MyString goodbye = new MyString(arr);
    System.out.println(hello.concat(goodbye.getOneString()));
    System.out.println(hello.equals(goodbye)); // works, prints false
    System.out.println(hello.equals(hello));  //works, prints true
    }
    }