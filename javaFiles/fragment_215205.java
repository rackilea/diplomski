class Key {
    private String key = new String();
    private void generateAndPrint() {
        Random r = new Random();

        for (int i = 10; i > 0; i--) {
            int randomNumber = r.nextInt(10) + 48;
            int randomLetter = r.nextInt(26) + 97;
            int branchSwitch = r.nextInt(2);

            if (branchSwitch == 1) {
                // System.out.print((char)randomNumber);
                key = key + (char) randomNumber;
            } else
                key = key + (char) randomLetter;
            // System.out.print((char)randomLetter);
        }
        System.out.print(key);
    }

    public static void main(String[] args) {
        Key key = new Key();
        key.generateAndPrint();
    }
}