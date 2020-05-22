public class A {
    public void res(int a){
        if (a < 5) {
            res(a);  
            ++a;
        }  
        System.out.println(a);
    }
}