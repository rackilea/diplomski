public static void main(String[] args) throws ParseException {
    Map<Character, Function<Integer, String>> commands = new HashMap<>();
    commands.put('a', Guitar::funtion1); // method reference
    commands.put('b', number -> funtion1(number));

    char cmd = 'a';
    Function<Integer, String> result = commands.get(cmd);                 // Function
    System.out.println("Return value is " + result.apply(55));            // 55 bar
    System.out.println("Return value is " + commands.get('b').apply(32)); // 32 bar
}

public static String funtion1(int text) {
    System.out.println("hello");
    return text + " bar";
}