public static void main(String... args) {

    String input = "This is a simple test string+++++";

    System.out.println("charCounterV1First: first most Character: "
            + charCounterV1First(input));
    System.out.println("charCounterV1Last: last most Character: "
            + charCounterV1Last(input));

}

public static char charCounterV1First(String input) {
    ArrayList<Character> list = new ArrayList<Character>();
    for (Character c : input.toCharArray()) {
        list.add(c);
    }

    int max = 0;
    Character mostChar = null;
    ArrayList<Character> remList = new ArrayList<Character>();
    while (list.size() > 0) {
        Character nextChar = list.get(0);
        int count = Collections.frequency(list, nextChar);
        if (count > max) {
            max = count;
            mostChar = nextChar;
        }
        remList.clear();
        remList.add(nextChar);
        list.removeAll(remList);
    }
    return mostChar;
}

public static char charCounterV1Last(String input) {
    ArrayList<Character> list = new ArrayList<Character>();
    for (Character c : input.toCharArray()) {
        list.add(c);
    }

    int max = 0;
    Character mostChar = null;
    ArrayList<Character> remList = new ArrayList<Character>();
    while (list.size() > 0) {
        Character nextChar = list.get(0);
        int count = Collections.frequency(list, nextChar);
        if (count >= max) {
            max = count;
            mostChar = nextChar;
        }
        remList.clear();
        remList.add(nextChar);
        list.removeAll(remList);
    }
    return mostChar;
}