public static void main(String[] args) {
    String str = "aabbccdefgh";
    int count = 0;
    for (int i = 0; i < str.length(); i++) {
        if (str.substring(0, i).contains(str.charAt(i) + ""))
            System.out.println();

        else
            count++;
    }
    System.out.println(count);

}