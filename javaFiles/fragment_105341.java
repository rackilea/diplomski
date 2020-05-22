@Override
public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;

    @SuppressWarnings("unchecked")
    final CircularList<T> other = (CircularList<T>) obj;

    if(other.length != this.length) {
        return false;
    }

    Element<T> current = this.first;
    Element<T> otherCurrent = other.first;
    int offset = 0;
    boolean found = false;
    do {
        found = checkSequence(current, otherCurrent);
        if(!found) {
            offset++;
            otherCurrent = otherCurrent.next;
        }
    } while(!found && offset < length) ;

    return found;
}

private boolean checkSequence(Element<T> current, Element<T> otherCurrent) {
    int i = 0;
    while(i < length && current.info == otherCurrent.info) {
        current = current.next;
        otherCurrent = otherCurrent.next;
        i++;
    }

    return i == length;
}