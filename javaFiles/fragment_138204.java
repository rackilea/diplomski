import java.util.*;
import java.io.*;

public class Main {

public static void main(String[] args) {
    try{
        String input = String.valueOf(args[0]);//assuming there will always be an input from command line
        String value = "";

        ArrayList al = new ArrayList();

        for(int i = 0; i < input.length(); i++){
            value = "" + input.charAt(i);
            al.add(value);
        }

        Iterator it = al.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
            it.remove();
        }

    }catch(IOException e){
        System.out.println(e.toString());
    }
}

}