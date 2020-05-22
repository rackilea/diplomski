import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class Test {

    public static void main(String[] args) throws FileNotFoundException{
        String filename = "text.txt";
        Scanner sc = new Scanner(new File(filename));
        String s;
        int i = 0;
        int firstVal = 0;
        ArrayList<Integer>x=new ArrayList<Integer>();
        ArrayList<Integer>y=new ArrayList<Integer>();
        while(sc.hasNext()){
            s=sc.next();
            if( s.trim().isEmpty() )
                continue;
            if( i<1 ){
                firstVal = Integer.valueOf(s).intValue();
            }else{
                if(i%2 > 0 ){
                    x.add(Integer.valueOf(s));
                }else{
                    y.add(Integer.valueOf(s));
                }
            }
            i++;
        }
        for(int xv: x){
            System.out.println(xv);
        }
        System.out.println("-----------------");
        for(int yv: y){
            System.out.println(yv);
        }
    }
}