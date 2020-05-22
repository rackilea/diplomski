class MyList<T> implements Iterable<T> {

    Object[] arr;
    int size;

    public MyList() {
        arr = new Object[10];
    }
    public void add(T value) {
        arr[size++] = value;
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> iterator = new Iterator<T>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public T next() {
                return (T)arr[index++];
            }

            @Override
            public void remove() {

            }
        };

        return iterator;
    }
}

class Main {

    public static void main(String[] args) {

        MyList<String> myList = new MyList<String>();
        myList.add("abc");
        myList.add("AA");

        for (String str: myList) {
            System.out.println(str);
        }
    }
}