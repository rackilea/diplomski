import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<String> dayList = new ArrayList<String>();

        int userInputNumber = 1234567;

        String userInputAsString = String.valueOf(userInputNumber);


        for (int i = 0; i < userInputAsString.length(); i++) {
            char dayAsNumericChar = userInputAsString.charAt(i);

            String day;
            switch (dayAsNumericChar) {
            case '1':
                day = "Sunday";
                break;
            case '2':
                day = "Monday";
                break;
            case '3':
                day = "Tuesday";
                break;
            case '4':
                day = "Wednesday";
                break;
            case '5':
                day = "Thursday";
                break;
            case '6':
                day = "Friday";
                break;
            case '7':
                day = "Saturday";
                break;
            default:
                throw new RuntimeException("Invalide number: " + dayAsNumericChar);
            }
            if (dayList.contains(day)) {
                throw new RuntimeException("Day: " + day + " is picked twice");
            }
            dayList.add(day);


        }
        System.out.println(userInputAsString);
        for (String s : dayList) {
            System.out.println(" -> " + s);
        }
    }

}