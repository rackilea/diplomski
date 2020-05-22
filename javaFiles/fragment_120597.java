@Override
public int compare(String s1, String s2) {      
    int cmp = s1.compareToIgnoreCase(s2);
    if (cmp == 0)
        cmp = s1.compareTo(s2);
    return cmp;
}