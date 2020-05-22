public static boolean matchDice(String dice) {

    char[] diceArray = dice.toCharArray();
    int pairs = 0;

    for (int i = 0; i < 4; i++) {

        for (int j = i + 1; j < dice.length(); j++) {


            if (diceArray[i] == diceArray[j]) {

                diceArray[i] = 'X';
                diceArray[j] = 'Y';
                pairs++;
            }

        }
    }
    return (pairs > 1);
}