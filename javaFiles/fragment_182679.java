public int compareTo(Element that) {
    final int comp = key.compareTo(that.key);
    if (comp < 0)
        return -1;
    else if(comp > 0)
        return 1;
    else
        return 0;
}