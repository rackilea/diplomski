String inputWord = "john";
    ArrayList<String> wordlist = new ArrayList<String>();
    wordlist.add("rambo");
    wordlist.add("john");
    for (ListIterator<String> iterator = wordlist.listIterator(); iterator
            .hasNext();) {
        String z = iterator.next();
        if (z.equals(inputWord)) {
            iterator.remove();
        }
    }
    System.out.println(wordlist.size());