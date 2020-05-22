import java.util.Arrays;

public class PrintSetCombIterative{

    public static void main(String[] args){
            String[] set1 = {"1","2"};
            String[] set2 = {"A","B","C"};
            String[] set3 = {"$", "%", "£", "!"};
            Object[][] sets = {set1, set2, set3};

            printCombinations(sets);
    }


    private static void printCombinations(Object[][] sets){
        int[] counters = new int[sets.length];

        do{
           System.out.println(getCombinationString(counters, sets));
        }while(increment(counters, sets));
    }

    private static boolean increment(int[] counters, Object[][] sets){
            for(int i=counters.length-1;i>=0;i--){
                if(counters[i] < sets[i].length-1){
                    counters[i]++;
                    return true;
                } else {
                    counters[i] = 0;
                }
            }
            return false;
    }

    private static String getCombinationString(int[] counters, Object[][] sets){
        String combo = "{";
        for(int i = 0; i<counters.length;i++){
            combo = combo+sets[i][counters[i]]+",";
        }
        return combo.substring(0,combo.length()-1)+"}";

    }
}