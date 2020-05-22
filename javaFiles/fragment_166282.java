interface Folder<U> {
    U fold(Iterable<? extends U> items);
}

class Sum<T extends Number<T>> implements Folder<T> {
    public T fold(Iterable<? extends T> items) {
        //...
    }
}

class FoldUtils {
    static <E> E foldDeep(Folder<E> folder, Iterable<? extends Iterable<? extends E>> itemses) {
        Collection<E> partialResults = new ArrayList<>();
        for (Iterable<? extends E> items : itemses)
            partialResults.add(folder.fold(items));
        return folder.fold(partialResults);
    }
}

//...
FoldUtils.foldDeep(new Sum<>(), list);