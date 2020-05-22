class Test{

    public int i=2;
}

public class Main {
public static void main(String[] args) {

    Test t1 = new Test();
    t1.i=0;

    Test t2 = new Test();
    t2.i=1;


    System.out.println(t1.i+" "+t1);
    System.out.println(t2.i+" "+t2);

    test(t1,t2);

    System.out.println(t1.i+" "+t1);
    System.out.println(t2.i+" "+t2);



}

public static void test(Test a, Test b){
    Test swap=a;
    a=b;
    b=swap;

    System.out.println(a.i+" "+a);
    System.out.println(b.i+" "+b);
}

}
/*
output:
0 Test@3c56b64c
1 Test@60da5686
1 Test@60da5686
0 Test@3c56b64c
0 Test@3c56b64c
1 Test@60da5686
*/