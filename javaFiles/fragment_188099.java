static LinkedHashMap<Character, Integer> charMap = new LinkedHashMap<Character, Integer>();

public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    System.out.print("Enter a string(only lowercase):    ");
    String pText = in.nextLine();
    pText = pText.toLowerCase();
    for (int i = 0; i < pText.length(); i++) {
        if (charMap.containsKey(pText.charAt(i))) {
            charMap.put(pText.charAt(i), charMap.get(pText.charAt(i)) + 1);
        } else {
            charMap.put(pText.charAt(i), 1);
        }
    }

    if (!charMap.isEmpty()) {
        StringBuilder builder = new StringBuilder();
        for (Character character : charMap.keySet()) {
            int value = charMap.get(character);
            if (value > 2) {
                builder.append(character);
                builder.append(value);
            } else {
                for (int i = 1; i <= value; i++) {
                    builder.append(character);
                }
            }
        }
        System.out.println(builder);
    } else {
        System.out.println("Please enter the string");
    }
}