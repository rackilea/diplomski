List<String> items = Arrays.asList("one", "two", "three", "four", "five", "six");
int index = find(items, startsWithPredicate("th"));
System.out.println(index);


public static Predicate<String> startsWithPredicate(final String key) {
    return new Predicate<String>(){
        @Override
        public boolean apply(String item) {
            return item.startsWith(key); 
        }
    };
}

public static <T> int find(Collection<T> items, Predicate<T> predicate) {
    int index = 0;
    for(T item: items) {
        if(predicate.apply(item)) {
            return index;
        }
        index++;
    }
    return -1;
}

interface Predicate<T> {
    boolean apply(T item);
}