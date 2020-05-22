import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Array<E> {


public static int brojDoProsek(ArrayList a){
    //Code here...
    double average = 0.0;
    Integer sum = new Integer(0);

    for(int i = 0; i < a.size(); i++){
        //sum = sum + a.get(i);
    }

    average = sum / a.size();



    return 0;
}

public static void main(String[] args) throws IOException{
    BufferedReader stdin = new BufferedReader( new InputStreamReader(System.in)); 
    String s = stdin.readLine();
    int N = Integer.parseInt(s);

    //Code here...
    ArrayList <Integer> niza = new ArrayList<Integer>(N);

    String b;
    for(int i = 0; i < N; i++){
        b = stdin.readLine();
        int temp = Integer.parseInt(b);

        niza.add(i, temp);
    }

    System.out.println(brojDoProsek(niza));     
}