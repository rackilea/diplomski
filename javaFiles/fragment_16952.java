private static boolean isValidDate(String input) {
        String formatString = "MM/dd/yyyy";

        try {
            SimpleDateFormat format = new SimpleDateFormat(formatString);
            format.setLenient(false);
            format.parse(input);
        } catch (ParseException e) {
            return false;
        } catch (IllegalArgumentException e) {
            return false;
        }

        return true;
    }

public static void main(String[] args){
        System.out.println(isValidDate("45/23/234")); // false
        System.out.println(isValidDate("12/12/2111")); // true
    }