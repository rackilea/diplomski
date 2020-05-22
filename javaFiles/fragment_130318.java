import java.util.ArrayList;
import java.util.Arrays;

public class test19{
    public static void main(String[]args){
        ArrayList<Integer> arrayListA = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
        ArrayList<Integer> arrayListB = new ArrayList<Integer>(Arrays.asList(11, 12, 13, 14, 15, 16, 17));
        System.out.println(merge(arrayListA,arrayListB));
    }

    public static ArrayList<Integer> merge (ArrayList<Integer> a, ArrayList<Integer> b){
        ArrayList<Integer> merge = new ArrayList<Integer>();

        if (a.size()<b.size()) {
            //here we check which list is the smallest and use that one (so we don't try to add blankspaces from the longer list to the merge list)
            for(int i=0; i<a.size(); i++){
                merge.add(a.get(i));
                merge.add(b.get(i));    
            }
            for(int j=a.size(); j<b.size(); j++){
                merge.add(b.get(j)); //here we add the leftover numbers to the list    
            }
        } else { //this means that list A is bigger than list B
            for(int i=0; i<b.size(); i++){
                merge.add(a.get(i));
                merge.add(b.get(i));
            }
            for(int j=b.size(); j<a.size(); j++){
                merge.add(a.get(j));    
            }
        }
        return merge;
    }
}