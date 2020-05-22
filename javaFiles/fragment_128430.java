private static final int ACCOUNT_NUMBER_COUNT = 1;
private static final int FIRST_NAME_COUNT = 2;
private static final int LAST_NAME_COUNT = 3;
private static final int BALANCE_COUNT = 4;
private static final int LAST_VARIABLE_COUNT = 5;    

List<String> accountNumbers = new ArrayList<String>();
List<String> firstNames = new ArrayList<String>();
List<String> lastNames = new ArrayList<String>();
List<String> balances = new ArrayList<String>();
List<String> lastVariables = new ArrayList<String>();

int sortCount = 1;

// Other things...

do {
    if (sortCount == ACCOUNT_NUMBER_COUNT) {
        accountNumbers.add(temp2);
    } else if (sortCount == FIRST_NAME_COUNT) {
        firstNames.add(temp2);
    } else if (sortCount == LAST_NAME_COUNT) {
        lastNames.add(temp2);
    } else if (sortCount == BALANCE_COUNT) {
        balances.add(temp2);
    } else if (sortCount == LAST_VARIABLE_COUNT) {
        lastVariables.add(temp2);
    }

    if (sortCount < 5) {
        sortCount++;
    } else {
        sortCount = 1;
    }
} while (account2.hasNext());