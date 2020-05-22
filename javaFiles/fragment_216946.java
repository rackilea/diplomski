public static void main(String[] args) throws Exception {
    char character = 'A';
    char[] characters = { 'U', 'M', 'Y', 'Q', 'I', 'A', 'L', 'D', 'P', 'F', 'E', 'G', 'T', 'Z', 'V', 'W', 'H', 'O', 'X', 'J', 'C', 'R', 'B', 'S', 'N', 'K' };

    System.out.println(Arrays.toString(characters));      
    shiftRight(character, characters);
    System.out.println(Arrays.toString(characters));
}