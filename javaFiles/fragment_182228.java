public int compare(Name n1, Name n2) {
    // TODO Auto-generated method stub
    int compare = n1.getNm().compareTo(n2.getNm());
    if (compare == 0) {
        return Integer.compare(n1.getSeatnum(), n2.getSeatnum());
    } else {
        return compare;
    }
}