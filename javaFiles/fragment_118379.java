public class Main {
    public static void main(String[] args) {
        String str1 = "ABCD  ";
        String str2 = " BDD  ";
        String str3 = "  CDEF";
        String[] reversed = getReversed(str1, str2, str3);  // reverse rows with columns

        for(int i=0; i< reversed.length; i++){
            String trimedString = reversed[i].trim();  // removes spaces that around the string
            System.out.println(findMaxOccurrenceCharValue(trimedString));  // counts the maximum occurrence char
        }
    }

    private static String[] getReversed(String str1, String str2, String str3){
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        char[] s3 = str3.toCharArray();

        String[] newStr = new String[6];
        for(int i =0; i<6; i++){
            newStr[i] = "" + s1[i] + s2[i] + s3[i];
        }
        return newStr;
    }

    private static String findMaxOccurrenceCharValue(String str) {
        char[] array = str.toCharArray();
        int[] count = new int[1000];
        for(char c: array){
            count[c]++;
        }

        // find the max occurrence character and number of occurrence
        String maxCharacter = "";
        int maxValue = -1;
        for(int i=0;i< array.length;i++){
            if(count[array[i]] > maxValue){
                maxValue = count[array[i]];
                maxCharacter = String.valueOf(array[i]);
            }
        }
        return  maxCharacter + "=" + maxValue;
    }
}