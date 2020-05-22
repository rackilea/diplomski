public void test(int a)
{
    if(a<5) {
        System.out.print(a);
        test(++a);
    } else {
        System.out.println("fin");
    }
}