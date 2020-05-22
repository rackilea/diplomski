@SuppressWarnings("rawtypes")
public static final FBag EMPTY = new FBag<>(null, null);

@SuppressWarnings("unchecked")
public static final <T> FBag<T> empty() {
    return (FBag<T>) EMPTY;
}