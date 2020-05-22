public class Card {

    public static String fromString(String string) {
        char value = string.charAt(0);
        String textValue = valueToText(value);
        String suit = getSuit(string.charAt(2));
        return String.format("%s of %s (value = %c)", textValue, suit,
                value);
    }

    private static String getSuit(char value) {
        switch (value) {
        case 'H':
            return "hearts";
        case 'S':
            return "spades";
        default:
            return "";
        }
    }

    private static String valueToText(char value) {
        switch (value) {
        case '2':
            return "Two";
        case '3':
            return "Three";

        default:
            return "";
        }
    }
}