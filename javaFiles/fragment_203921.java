public static void main(String[] args) {
    String record1 = "12/18/2009 02:08:26 Admitted Doe, John (Card #111) at South Lobby [In]";
    String record2 = "12/18/2009 02:08:26 Admitted Van Halen, Eddie (Card #222) at South Lobby [In]";
    String record3 = "12/18/2009 02:08:26 Admitted Thoreau, Henry David (Card #333) at South Lobby [In]";

    summary(record1);
    summary(record2);
    summary(record3);
}

public static void summary(String record) {
    String[] tokens = record.split(" ");

    String date = tokens[0];
    String time = tokens[1];

    String regEx = "Admitted (.*), (.*) \\(Card #(.*)\\)";
    Pattern pattern = Pattern.compile(regEx);
    Matcher matcher = pattern.matcher(record);
    matcher.find();

    String lastName = matcher.group(1);
    String firstName = matcher.group(2);
    String cardNumber = matcher.group(3);

    System.out.println("\nDate: " + date);
    System.out.println("Time: " + time);
    System.out.println("First Name: " + firstName);
    System.out.println("Last Name: " + lastName);
    System.out.println("Card Number: " + cardNumber);
}