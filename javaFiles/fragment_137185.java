$ cat Foo.java 
public class Foo {
    public static void main(String[] args) throws InterruptedException
    {
        for(int i = 0 ; i < 1000 ; i++)
        {
            System.out.println(i);
            Thread.sleep(1000);
        }
    }
}

$ javac Foo.java
$ nohup java Foo > foo.txt &
[3] 29542
$ cat foo.txt 
0
1
2
3
4
5
$ exit