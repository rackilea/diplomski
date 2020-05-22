import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

public class AddTwoArray {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<String>();
        list1.add("Windows 12 3 5");
        list1.add("Apple 12 1");
        list1.add("Orange");
        List<String> list2 = new ArrayList<String>();
        list2.add("Apple 4 12 1");
        list2.add("Orange 5");
        list2.add("Windows");

        TreeSet s1 = new TreeSet<String>(list1);
        TreeSet s2 = new TreeSet<String>(list2);
        TreeSet s3 = new TreeSet<String>(list1);
        TreeSet s4 = new TreeSet<String>(list2);
        s1.removeAll(s2);
        s4.removeAll(s3);
        List<String> diff = new ArrayList<String>(s1);
        List<String> diff1 = new ArrayList<String>(s4);

        List<String> diffArray = null;
        for (int tmp = 0 ; tmp < diff.size(); tmp++) {
            diffArray = findDiff(diff.get(tmp).split(" "), diff1.get(tmp).split(" ")); // call method findDiff

            if(diffArray != null){
                for(String tmp1: diffArray){
                    String[] diffSplit = tmp1.split(" ");
                    for(int i =0; i < diffSplit.length; i++){
                        System.out.print(diffSplit[i] + " ");
                    }
                }
            }
            System.out.println();
        }
    }

    public static List<String> findDiff(String[] diff, String[] diff1) { // find the different between two arrays
        HashSet<String> map = new HashSet<String>();
        List<String> diffArray = new ArrayList<String>();
        diffArray.add(diff[0]); // add unique key
        for (String i : diff){
            map.add(i);
        }
        for (String i : diff1) {
            if (!map.contains(i)){ //find different element between diff and diff1 
                diffArray.add(i);
            } 
        }

        map = new HashSet<String>();

        for (String i : diff1)
            map.add(i);
        for (String i : diff) {
            if (!map.contains(i)){   //find different element between diff1 and diff
                diffArray.add(i);
            } 
        }
        return diffArray; //diff array
    }
}