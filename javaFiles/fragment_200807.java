private final int maxSize;
public MyArrayDeque(int maxSize) {
    super(maxSize);
    this.maxSize= maxSize;
}

@Override
public void addFirst(E e) {
    if (maxSize == size()) 
        removeLast();
    super.addFirst(e);
}

@Override
public void addLast(E e) {
    if (maxSize == size()) 
        removeFirst();
    super.addLast(e);
}