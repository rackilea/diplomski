public static void main (String[] args) {

    ArrayList<Integer> list = new ArrayList<Integer>(); // store code[] value
    ArrayList<String> listS = new ArrayList<String>(); // store string w/o numbers

    int code[] = {0, 100, 200, 300}; //example
    String text[] = {"M12", "Dog", "117Cat", "Pig"}; //example

    for (int i = 0; i < text.length; i++) {

        if (! text[i].matches(".*\\d+.*")) { // VERY IMP REGEX TO TEST IF STRING CONTAINS ANY NUMBER
            list.add(i); // or add(code[i]);
            listS.add(text[i]);
        }
    }

    int newCode[] = new int[list.size()];
    int idx = 0;
    for (int x : list) {
        newCode[idx++] = x;
    }

    String newText[] = listS.toArray(new String[list.size()]);

    for (int i=0; i < newCode.length; i++) {
        System.out.println(newCode[i] + " : " + newText[i]);
    }
}