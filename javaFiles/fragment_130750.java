import java.util.ArrayList;

public class Test001
{
    public static final String DNA = "ATGTTGCTGGCATAGATGTTAACTTCCAC";

    public static Integer[] search(String sought)
    {
        ArrayList<Integer> hits = new ArrayList<Integer>();
        int startIndex = 0;
        while (startIndex < DNA.length())
        {
           int foundIndex = DNA.indexOf(sought, startIndex);
           if (foundIndex >= 0){
               hits.add(foundIndex);
               startIndex = foundIndex + 1;
           }else{
               break;
           }
        }
        System.out.println(hits);
        Integer[] found = new Integer[hits.size()]; 
        return hits.toArray(found);
    }

    public static void main(String args[]) {
        Integer[] found = search("AC");
        for (int foundIndex : found){
            System.out.println(foundIndex);
        }
    }
}