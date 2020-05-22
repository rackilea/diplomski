public int compareTo(DoubleKey<K, J> that) {

    int cmp = this.getFirstKey().compareTo(that.getFirstKey());
    if (cmp == 0)
        cmp = this.getSecondKey().compareTo(that.getSecondKey());
    return cmp;
}