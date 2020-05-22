public int indexOf(Object o) {
    E[] a = this.a;
    if (o == null) {
        for (int i = 0; i < a.length; i++)
            if (a[i] == null)
                return i;
    } else {
        for (int i = 0; i < a.length; i++)
            if (o.equals(a[i]))
                return i;
    }
    return -1;
}