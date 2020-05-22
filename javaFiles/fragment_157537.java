int x = 0;

public void test(int x)
{
   System.out.println(x);
   System.out.println(this.x);
}

test(2);
//prints
//2
//0