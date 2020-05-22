public class ClientsMap {

private static ArrayListMultimap<Integer, String> multimapCardNumber = ArrayListMultimap.create();

...

public static void addCardNumber(String cardNumberValue) {
        multimapCardNumber.put(multimapCardNumber.size(), cardNumberValue);
    }

public static String returnSpecificCardNumber(int specificCardNumberPosition) {
        String returnedCardNumber = multimapCardNumber.get(specificCardNumberPosition - 1).get(0);
        return returnedCardNumber;
    }

    }