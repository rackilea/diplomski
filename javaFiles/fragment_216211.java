List<String> wordList = new LinkedList<>();
wordList.add("test");
wordList.add("hello");
wordList.add("test");
wordList.add("world");
wordList.add("test");
wordList.add("hello");
wordList.add("test");
wordList.add("hello");

String word = "test";

System.out.println(word + " Occured: " + Collections.frequency(wordList,word) + " times");