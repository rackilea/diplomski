public static void main(String[] args) {
    ArrayList<String> messageList = new ArrayList<String>();
    String text = "abc";
    byte[] bytes = text.getBytes();
    StringBuilder binary = new StringBuilder();
    for (byte b : bytes) {
        int val = b;
        for (int i = 0; i < 8; i++) {
            binary.append((val & 128) == 0 ? 0 : 1);
            val <<= 1;
        }
        binary.append(' ');
    }
    messageList.add(binary.toString());

    System.out.println(Arrays.toString(bytes));

    for (String object : messageList) {
        System.out.println("'" + text + "' to binary: " + object);
    }

    // this part below to help you to save 2-bit binary converted in int
    // arraylist to store string
    ArrayList<String> stringList = new ArrayList<String>();
    for (int i = 0; i < text.length(); i++) {
        stringList.add(messageList.get(0).split(" ")[i]);
    }
    // arraylist to store int converted
    ArrayList<Integer> intList = new ArrayList<Integer>();
    for (String str : stringList) {
        for (int i = 0; i < str.length(); i += 2) {
            intList.add(Integer.parseInt(str.substring(i, i + 2), 2));
            System.out.print(str.substring(i, i + 2) + " ");
        }

    }
    System.out.println();
    // nowretrieve int in arraylist to convert in 2-binary if you wont
    for (Integer integer : intList) {
        System.out.print(integer + "  ");
    }
}