public int getScore(String input)
    {
        /* Initial score is 0 but then will increase based on letter value*/
        int totalScore = 0;

        /* Takes countryInput value and converts it to a character array*/
        char[] word = input.toLowerCase().toCharArray();

        /* Grouped letters together based on point values */
       //char[][] letters = {{'a','e','i','o','u','l','n','s','t','r'},{'d','g'},
       //    {'b','c','m','p'},{'f','h','v','w','y'},{'k'},{'j','x'},{'q','z'}};

       /*Store letters grouping in map with their value as Key*/
       Map<Integer, List<Character>> letters =  new HashMap<>();
       letters.put(1, Arrays.asList('a','e','i','o','u','l','n','s','t','r'));
       letters.put(2, Arrays.asList('d','g'));
       letters.put(3, Arrays.asList('b','c','m','p'));
       letters.put(4, Arrays.asList('f','h','v','w','y'));
       letters.put(5, Arrays.asList('k'));
       letters.put(6, Arrays.asList('j','x'));
       letters.put(7, Arrays.asList('q','z'));

       for(char ch: word) {
           for(Entry<Integer, List<Character>> entrySet : letters.entrySet()) {
               if(entrySet.getValue().contains(ch)) {
                   totalScore += entrySet.getKey();
                   break;
               }
           }
       }

       return totalScore;
    }