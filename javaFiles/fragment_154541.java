if (list != null) {
    int compare = word.compareTo(list.getWord());
    if (compare == 0) {
        return true;
    } else if (compare > 0) {
        return contain(list.getRight(), word);
    } else {
        return contain(list.getLeft(), word);
    }
}
return false;