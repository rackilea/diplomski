public static void main(String[] args) {
    String eOrR = "";
    int counter = 0;

    for (int i=0; i < 2147483647; i++) {
        int random = (int) (Math.random() * 2 + 1);

        if (random == 2) {
            eOrR += "E";
            counter = 0;
        } else {
            eOrR += "R";
            ++counter;
        }

        if (counter >= 3) {
            System.out.println(eOrR + "\nThree R's in a row!");
            break;
        }
    }
}