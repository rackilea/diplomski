public boolean contains(Object o) {
    return indexOf(o) >= 0;
}

public int indexOf(Object o) {
    ...     
    for (int i = 0; i < size; i++)
    if (o.equals(elementData[i]))
        return i;
    ...
    return -1;
}