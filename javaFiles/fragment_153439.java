public class Testcalc
{

    public class Testcalc {

    public int calc_children( int aBoys, int aGirls) {
        int a_num_children = aBoys + aGirls;

        return a_num_children;
    }   

    public int calc_adults( int aMen, int bWomen) {
        int a_num_adults = aMen + bWomen;

        return a_num_adults;
    }
    public int calc_total(int a,int b)
    {
return a+b;
}

    public static void main(String[] args) {    

        Testcalc calc1 = new Testcalc();

      int aChildren = calc1.calc_children(4,6);
     int bAdults = calc1.calc_adults(5,8);
    int total=calc1.calc_total(aChildren,bAdults);

        System.out.println("Total Children " + aChildren);
        System.out.println("Total Adults " + bAdults);  
    System.out.println("Total" + total);

    }                               
}