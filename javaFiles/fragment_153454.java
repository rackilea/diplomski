for (int i = 0; i < characterList.size() - 1; i++) {
        System.out.println("1st Loop: " + characterList.get(i));
        System.out.println("1st Loop: " + characterList.get(i + 1));
        System.out.println("1st Loop: " + i);
        System.out.println();

        for (int j = 0; j < openParenthesis.length; j++) {
            if (characterList.get(i).equals(openParenthesis[j])) {
                if (characterList.get(i + 1).equals(closeParenthesis[j])) {
                    System.out.println("Nested Match");
                    System.out.println(characterList.get(i));
                    System.out.println(characterList.get(i + 1));
                    System.out.println();
                    characterList.remove(i);
                    characterList.remove(i);
                    i = -1;
                    break;
                }
            }
        }
    }