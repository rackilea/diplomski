public void swapCharactersAndPrint(String[] data, Map<Character, Character> replacements) {
        for (String string : data) {
            for (char c : string.toCharArray()) {
                if (replacements.containsKey(c)) System.out.print(replacements.get(c));
                else System.out.print(c);
            }
            System.out.println();
        }
    }