public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    char[] array = new char[] {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
            'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

    System.out.println("Please enter a sentence to parse.");
    String userString = input.nextLine();

    HashMap<Character, Integer> charint = new HashMap<>();

    for (Character c : userString.toCharArray()){
        if (charint.containsKey(c)) charint.replace(c, charint.get(c).intValue() + 1);
        else charint.put(c, 1);
    }

    for (int i = 0 ; i < array.length ; i++){
        System.out.println(array[i] + " : " + (charint.get(array[i]) == null ? "0" : charint.get(array[i])));
    }
}