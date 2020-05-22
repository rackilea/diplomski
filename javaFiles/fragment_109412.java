String text = ... // read the text somewhere

Set<String> keywords = new HashSet<>();
keywords.add("keyword1");
keywords.add("keyword2");

Trie trie = Trie.builder().addKeywords(keywords).build(); // with overlaps!