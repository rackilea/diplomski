private List<HashSet<Character>> createSubsets(char[] a) {
        List<HashSet<Character>> tempListList = new ArrayList<HashSet<Character>>();
        if (a.length == 0) {
            HashSet<Character> temp = new HashSet<Character>();
            //temp.add(' ');
            tempListList.add(temp);
            return tempListList;
        }
        char tempChar = a[a.length-1];
        List<HashSet<Character>> setList = createSubsets(Arrays.copyOf(a, a.length-1));
        for (HashSet<Character> charSet : setList) {
            HashSet<Character> tempSet = new HashSet<>(charSet);
            tempSet.add(tempChar);
            tempListList.add(tempSet);
        }
        setList.addAll(tempListList);
        return setList;
    }