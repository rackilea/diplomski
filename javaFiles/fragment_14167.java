class AutoExpandingList<T> {
    T[] list;
    int nextIndex;
    public AutoExpandingList() {
        this.list = new T[10];
        this.nextIndex = 0;
    }
    public void add(T item) {
        if (nextIndex >= list.length) {
            expandList();
        }
        list[nextIndex] = item;
        nextIndex++;
    }
    public void expandList() {
        T[] newList = new T[list.length*2];
        for (int i = 0; i < list.length; i++) {
            newList[i] = list[i];
        }
        this.list = newList;
    }
    public T get(int index) {
        return list[index];
    }
    // You could implement other methods here:
    //     remove(int index)
    //     insert(int index, T item)
    //     sort()
    //     etc...
}