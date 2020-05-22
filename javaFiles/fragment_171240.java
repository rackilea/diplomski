public static long uppercase2(String str){
    return Arrays.stream(str.split(" "))
            .map(word -> word.charAt(0))
            .filter(Character::isUpperCase)
            .count();
}