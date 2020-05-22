import java.util.*;

public class CheckVoid {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<Integer>();

        // Populating List 
        list.add(1); 
        list.add(2); 
        list.add(3); 
        list.add(4); 
        list.add(5); 

        // these give error although I saw a popup void 
        // did not give error but I put it null
        int size1 = list.notify().size();
        int size2 = list.wait(1).size();
        int size3 = list.add(1, 2).size();

    }

}