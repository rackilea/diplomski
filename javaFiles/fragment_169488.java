import java.util.Arrays;

public class PrintSetComb{

    public static void main(String[] args){
        Integer[] set1  = {1,2};
        Float[] set2    = {2.0F,1.3F,2.8F};
        String[] set3   = {"$", "%", "£", "!"};
        Object[][] sets = {set1, set2, set3};

        printCombinations(sets, 0, new Object[0]);
    }

    private static void printCombinations(Object[][] sets, int n, Object[] prefix){
        if(n >= sets.length){
            String outp = "{";
            for(Object o: prefix){
                outp = outp+o.toString()+",";
            }
            System.out.println(outp.substring(0,outp.length()-1)+"}");
            return;
        }
        for(Object o : sets[n]){
            Object[] newPrefix = Arrays.copyOfRange(prefix,0,prefix.length+1);
            newPrefix[newPrefix.length-1] = o;
            printCombinations(sets, n+1, newPrefix);
        }
    }
}