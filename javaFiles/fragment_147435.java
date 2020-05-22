public class Test001
{

    public static void main(String args[]) {
        Integer i1 = 10;
        Integer i2 = 10;
        if(i1==i2) {System.out.println("same object 1");}

        i1 = new Integer(10);
        i2 = new Integer(10);
        if(i1==i2) {System.out.println("same object 2");}

        i1 = 10024;
        i2 = 10024;
        if(i1==i2) {System.out.println("same object 3");}
    }
}