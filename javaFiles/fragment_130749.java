import java.util.ArrayList;

public class Test001
{
    public static final String DNA = "ATGTTGCTGGCATAGATGTTAACTTCCAC";

    public static Integer[] zoek(String gezocht)
    {
        ArrayList<Integer> dna = new ArrayList<Integer>();
        int i = 0;
        while (i < DNA.length())
        {
           int fromIndex = DNA.indexOf(gezocht, i);
           if (fromIndex >= 0){
               dna.add(fromIndex);
               i = fromIndex + 1;
           }else{
               break;
           }
        }
        System.out.println(dna);
        Integer[] zoek = new Integer[dna.size()]; 
        return dna.toArray(zoek);
    }

    public static void main(String args[]) {
        Integer[] ind = zoek("AC");
        for (int fromIndex : ind){
            System.out.println(fromIndex);
        }
    }
}