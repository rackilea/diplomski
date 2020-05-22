public static void main(String[] args) {
    System.out.println("The story of the 5 little ducks");
    for(int duck = 5 ; duck>0 ; duck--) {
        System.out.printf("%d little %s went out one day, over the hills and far away, mother duck said quack, quack, quack, quack", duck, ducksToWord(duck));
        System.out.printf(" but only %d little %s went back\n", duck-1, ducksToWord(duck-1));
    }
}

private static String ducksToWord(int duck) {
    if (duck == 1 || duck == 0) {
        return "duck";
    } 
    return "ducks";
}