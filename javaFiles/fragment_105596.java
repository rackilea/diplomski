ImmutableMultiset<String> top = Multisets.copyHighestCountFirst(myMultiset);

Iterator<Multiset.Entry<String>> it = top.entrySet().iterator();

for (int i = 0; (i < 5) && it.hasNext(); i++) {
    Multiset.Entry<String> entry = it.next();

    String word = entry.getElement();
    int count = entry.getCount();

    // do something fancy with word and count...
}