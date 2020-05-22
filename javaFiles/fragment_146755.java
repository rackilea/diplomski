public class ItalianNumberToStringConverter {

    public static void main(String[] args) {
        System.out.println(convertNumberToString(3));
    }

    public static String convertNumberToString(Integer i) {
        String[] ItNums = {
                "",
                "uno",
                "due",
                "tres",
                "quattro",
                "clinque"
        };

        String myString = ItNums[i];

        for (String num : ItNums) {
            System.out.println(num);
        }

        return myString;
    }
}