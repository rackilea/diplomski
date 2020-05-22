char[] chars = string.toCharArray();
    HashMap<Character, Integer> countMap = new HashMap<Character, Integer>();
    for (char aChar : chars) {
        if (countMap.containsKey(aChar)) {
            countMap.put(aChar, countMap.get(aChar) + 1);
        } else {
            countMap.put(aChar,1);
        }
    }

    //determine max occurence
    int max = 0;
    for (Integer i: countMap.values()) {
        if (max < i) {
            max = i;
        }
    }

    //print all satisfiying max occurrence
    for (Map.Entry<Character, Integer> e: countMap.entrySet()) {
        if (e.getValue() == max) {
            System.out.println("The number of letter " + e.getKey() + "  is " + max);
        }
    }