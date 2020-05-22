public class LevenshteinDistance {

    private static int minimum(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

    public static int computeDistance(CharSequence str1,
            CharSequence str2) {

        int[][] distance = new int[str1.length() + 1][str2.length() + 1];

        for (int i = 0; i <= str1.length(); i++){
            distance[i][0] = i;
        }
        for (int j = 0; j <= str2.length(); j++){
            distance[0][j] = j;
        }
        for (int i = 1; i <= str1.length(); i++){
            for (int j = 1; j <= str2.length(); j++){
                distance[i][j] = minimum(
                    distance[i - 1][j] + 1,
                    distance[i][j - 1] + 1,
                    distance[i - 1][j - 1]
                        + ((str1.charAt(i - 1) == str2.charAt(j - 1)) ? 0 : 1));
            }
        }
        int result = distance[str1.length()][str2.length()];
        //log.debug("distance:"+result);
        return result;
    }


    public static void main(String[] args) {
        String sent1="Mary and Meera are my classmates.";
        String sent2="Meera and Mary are my classmates.";       
        String sent3="Alice and Bobe are not my classmates.";
        String sent4="Some totally different sentence.";

    System.out.println("Distance between \n'"+sent1+"' \nand '"+sent2+"': \n"+computeDistance(sent1, sent2));
    System.out.println("Distance between \n'"+sent1+"' \nand '"+sent3+"': \n"+computeDistance(sent1, sent3));
    System.out.println("Distance between \n'"+sent1+"' \nand '"+sent4+"': \n"+computeDistance(sent1, sent4));

        }
}