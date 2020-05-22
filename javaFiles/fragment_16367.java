public class Main {
    public static void main (String[]args) throws IOException, ParseException {
        int[] nums = {1,2,3,4,5};
        System.out.println("your numbers are "+formatArray(nums));
    }

    public static String formatArray(int[] tallrekke){
        String result = "";
        for(int i=0; i<tallrekke.length; i++){
            if(i>0 && i < tallrekke.length -1) {
                result +=  ", ";
            }
            else if (i> tallrekke.length -2) {
                result += " og ";
            }
            result +=tallrekke[i];
        }
        return result;
    }
}