public static void main(String[] args) {
    String[] arrayNames = {"Sam", "Sara", "Tim", "Bob", "Kate"};

    for(int i = arrayNames.length-1; i >= 0 ; i--) {
        System.out.print(arrayNames[i] + (i != 0 ? + "," : ""));
    }
}