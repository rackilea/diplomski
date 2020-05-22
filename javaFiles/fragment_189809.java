public static char selectAChar(String s){

    Random random = new Random();
    int index = random.nextInt(s.length());
    return s.charAt(index);

}