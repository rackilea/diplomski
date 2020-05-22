List<Integer> allLetters = new ArrayList<Integer>();
// add some data
Collections.shuffle(allLetters);

List<Integer> someLetters = allLetters.subList(0, 40);
// Remove duplicates if you want
adapter = new YourAdapter(context, someLetters);