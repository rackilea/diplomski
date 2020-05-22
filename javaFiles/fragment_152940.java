import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EvenOdd{
    private static List<Integer> array;
    private static List<Integer> even;
    private static List<Integer> odd;
    private static Scanner sc;

    public EvenOdd() {
        array = new ArrayList<>();
        even = new ArrayList<>();
        odd = new ArrayList<>();
        sc = new Scanner(System.in);
    }


    public void classify(){
        for(int n : array){
            if(n % 2 == 0) even.add(n);
            else odd.add(n);
        }
    }

    public void fillArray(){
        int n = sc.nextInt();
        do { 
            array.add(n); 
            n = sc.nextInt();
        } while (n != -1);
    }

    public void display(List<Integer> list){
        for(Integer i : list)
            System.out.println(i);
    }

    public List<Integer> getEven() {
        return even;
    }

    public List<Integer> getOdd() {
        return odd;
    }

    public static void main(String[] args){
        EvenOdd eo = new EvenOdd();
        eo.fillArray();
        eo.classify();
        System.out.println("even");
        eo.display(eo.getEven());
        System.out.println("odd");
        eo.display(eo.getOdd());
    }
}