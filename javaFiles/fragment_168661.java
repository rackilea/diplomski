//0123456789012345678901
    String text = "Hello,my name is=Helen";
    Map<Character,Integer> map = new HashMap<Character,Integer>();

    boolean lastIsLetter = false;
    for (int i = 0; i < text.length(); i++) {
        char ch = text.charAt(i);
        boolean currIsLetter = Character.isLetter(ch);
        if (!lastIsLetter && currIsLetter) {
            map.put(ch, i);
        }
        lastIsLetter = currIsLetter;
    }

    System.out.println(map);
    // prints "{n=9, m=6, H=17, i=14}"