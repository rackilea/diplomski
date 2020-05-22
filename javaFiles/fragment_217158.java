import java.util.Collection;
import java.util.HashSet;
import java.util.Random;

public class UniqueRandom {

    static Random rnd=new Random();

    public static void main(String args[]){
        Collection<Integer> alreadyChosen = new HashSet<Integer>();
        for(int i=0;i<10;i++){
            System.out.println(getNextUniqueRandom (alreadyChosen));
        }
    }


    public static int getNextUniqueRandom(Collection<Integer> alreadyChosen){
        if (alreadyChosen.size()==90000){ //hardcoded 5 figure numbers, consider making a variable
             throw new RuntimeException("All 5 figure IDs used");
        }


        boolean unique=false;
        int value=0;
        while(unique==false){
            value=rnd.nextInt(90000)+10000;
            unique=!alreadyChosen.contains(value);
        }
        alreadyChosen.add(value);
        return value;
    }

}