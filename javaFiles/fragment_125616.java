public class TryOutClass {

    /**
     * Compares two dates and checks if they are equal using {@link String} comparison.
     * <p>
     * <strong>Important note:</strong><br>
     * This assumes the first date given is of the format "EEE, dd/MM/yy" and 
     * the second one is of the format "dd.MM.yyyy".
     * </p>
     * 
     * @param dateOne the first date to be compared to the second
     * @param dateTwo the second date to be compared to the first
     * @return <code>true</code> if the dates are equal, otherwise <code>false</code>
     */
    public static boolean datesEqual(String dateOne, String dateTwo) {
        // cut off the leading weekday abbreviation
        String processedDateOne = dateOne.substring(4, 12);

        // split the String by its delimiter (/)
        String[] temp = processedDateOne.split("/");

        // concatenate the parts to fit the format of the second date
        String comparableDateOne = temp[0] + "." + temp[1] + ".20" + temp[2];

        // return the result of the String comparison
        return comparableDateOne.equals(dateTwo);
    }

    /**
     * Compares two dates and checks if they are equal using the comparison of {@link LocalDate}.
     * <p>
     * <strong>Important note:</strong><br>
     * This assumes the first date given is of the format "EEE, dd/MM/yy" and 
     * the second one is of the format "dd.MM.yyyy".
     * </p>
     * 
     * @param dateOne the first date to be compared to the second
     * @param dateTwo the second date to be compared to the first
     * @return <code>true</code> if the dates are equal, otherwise <code>false</code>
     */
    public static boolean equalDates(String dateOne, String dateTwo) {
        // define two formattings
        DateTimeFormatter firstFormatter = DateTimeFormatter.ofPattern("dd/MM/yy");
        DateTimeFormatter secondFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        // create two LocalDates, the first one still needs to have the weekday abbreviation cut off
        LocalDate firstDate = LocalDate.parse(dateOne.substring(4, 12), firstFormatter);
        LocalDate secondDate = LocalDate.parse(dateTwo, secondFormatter);

        // return the result of the LocalDate comparison
        return firstDate.equals(secondDate);
    }

    /**
     * The main method that just executes both possibilities 
     * of comparing differently formatted date {@link String}s
     * @param args (unused) command line arguments
     */
    public static void main(String[] args) {
        String dateOne = "Wed 01/08/18";
        String dateTwo = "01.08.2018";

        System.out.println("#### datesEqual ####");
        String datesEqual = datesEqual(dateOne, dateTwo) ?
                "The dates are equal" : "The dates differ";
        System.out.println(datesEqual);

        System.out.println("#### equalDates ####");
        String equalDates = equalDates(dateOne, dateTwo) ?
                "The dates are equal" : "The dates differ";
        System.out.println(equalDates);
    }
}