int countChr(String str) {
        System.out.println(str);
        if (str.length() == 0) {
            System.out.println("String has length 0, returning 0");
            return 0;
        }
        int count = 0;
        if (str.substring(0, 1).equals("A")) {
            System.out.println("Character is an 'A' adding 1 to the count");
            count = 1;
        }
        return count + countChr(str.substring(1));
}