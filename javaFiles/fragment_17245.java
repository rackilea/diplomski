public static void main(String[] args) {
    String secretPin = "2236";
    String currentPin = "6322";

    int match = 0;
    for (int i = 0; i < currentPin.length(); i++) {
        if (secretPin.contains(String.valueOf(currentPin.charAt(i)))) {
            secretPin = secretPin.replaceFirst(String.valueOf(currentPin.charAt(i)), "");
            match++;
        }
    }

    System.out.println(match);

}