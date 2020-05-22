@Override
public void push(E elt) {
    super.push(elt);
    while (this.size() > this.maxSize) {
        this.removeElementAt(this.size() - 1);
    }
}