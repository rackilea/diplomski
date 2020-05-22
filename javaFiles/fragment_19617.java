public boolean anagram(String firstWord, String secondWord) {
        firstWord = firstWord.toLowerCase();
        secondWord = secondWord.toLowerCase();
        char[] firstArray = firstWord.toCharArray();
        char[] secondArray = secondWord.toCharArray();
        int firstLength = firstWord.length();
        int secondLength = secondWord.length();

        Map<Character, Integer> firstDictionary = new HashMap<>();
        Map<Character, Integer> secondDictionary = new HashMap<>();

        for (firstLength = 0; firstLength < firstArray.length; firstLength++) {
           // System.out.println("checking the letter " + firstArray[firstLength] + " in array" + firstArray.toString());
            if (!firstDictionary.containsKey(firstArray[firstLength])) {
                firstDictionary.put(firstArray[firstLength], 1);
            } else {
                firstDictionary.put(firstArray[firstLength], firstDictionary.get(firstArray[firstLength]) + 1);
            }
        }

        for (secondLength = 0; secondLength < secondArray.length; secondLength++) {
            if (!secondDictionary.containsKey(secondArray[secondLength])) {
                secondDictionary.put(secondArray[secondLength], 1);
            } else {
                secondDictionary.put(secondArray[secondLength], secondDictionary.get(secondArray[secondLength]) + 1);
            }
        }

        if (firstDictionary.equals(secondDictionary)) {
            return true;
        } else {
            return false;
        }
    }