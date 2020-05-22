class test{
static int a=0;
int b;
public void set(int b)
{
this.b=a+b;
a=a+b;
}
public static void main(String[] args) {

test t1=new test();
t1.set(4);
System.out.println(t1.b);
t1.set(5);
System.out.println(t1.b);
}