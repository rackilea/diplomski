for (int i = 0; i < arraylist1.size(); i++) {
    for (int j = 0; j < stopwords.size(); j++) {
        if (stopwords.get(j).equals(arraylist1.get(i))) {
            arraylist1.remove(i);
            i--; // you have to look at the same index again!
        }
    }
}