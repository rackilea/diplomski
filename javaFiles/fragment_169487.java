public class PrintSetComb{
    public static void main(String[] args){
        String[] set1 = {"1","2"};
        String[] set2 = {"A","B","C"};
        String[] set3 = {"$", "%", "£", "!"};
        String[][] sets = {set1, set2, set3};

        printCombinations(sets, 0, "");
    }

    private static void printCombinations(String[][] sets, int n, String prefix){
        if(n >= sets.length){
            System.out.println("{"+prefix.substring(0,prefix.length()-1)+"}");
            return;
        }
        for(String s : sets[n]){
            printCombinations(sets, n+1, prefix+s+",");
        }
    }
}