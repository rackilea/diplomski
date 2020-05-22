for (int i = 0; i < ListOfAllPhrase.size(); i++) {

    // offset.add((ListOfAllPhrase.get(i)).length());

    List<Integer> matches = match(ListOfAllPhrase.get(i).toLowerCase(),
            line.toLowerCase());
    for (Integer integer : matches) {

        pairs.add(new Pair(integer, (ListOfAllPhrase.get(i)).length()
                + integer));
    }
}