for (int i = 0; i < n; i++) {
            // create a copy of wordList
            List<Integer> permWordList = new ArrayList<Integer>(wordList);

            // equiv to "word + str.charAt(i)"
            permWordList.add(strLis.get(i));  

            // create a copy of lis
            List<Integer> permStrList = new ArrayList<Integer>(lis);

            // equiv to "str.substring(0, i) + str.substring(i + 1)"
            permStrList.remove(i);  

            permutation(permWordList, permStrList);
        }