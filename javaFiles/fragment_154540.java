if (list != null) {
    if (word.equals(list.getWord()) || contain(list.getLeft(), word) || contain(list.getRight(), word)) {
        return true;
    }
}
return false;