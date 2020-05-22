String[] words = {"one", "two", "three", "two", "three", "three"};
    Map<String, Integer> map = new HashMap<String, java.lang.Integer>();
    for (String word : words) {
        int count = 0;
        if (map.containsKey(word)) {
            count = map.get(word);
        }
        map.put(word, ++count);
    }
    System.out.println(map);
    --> output: {two=2, one=1, three=3}