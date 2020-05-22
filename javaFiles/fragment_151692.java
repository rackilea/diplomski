public static void main(String[] args) {
    List<String> one = Arrays.asList("one","four","seven");
    List<String> two = Arrays.asList("two","five","eight");
    List<String> three = Arrays.asList("three","six");

    System.out.println(zipLists(one, two, three)); 
    //[one, two, three, four, five, six, seven, eight]
}

public static List<String> zipLists(List<String>... lists) {
    int maxSize = 0, totalSize = 0;
    List<Iterator<String>> iterators = new ArrayList<>(lists.length);
    for(List<String> list: lists) {
        int size = list.size();
        maxSize = Math.max(maxSize, size);
        totalSize += size;
        iterators.add(list.iterator());
    }
    List<String> mergedList = new ArrayList<>(totalSize);
    for(int i = 0; i < maxSize; i++) {
        for(Iterator<String> iterator: iterators) {
            if(iterator.hasNext()) {
                mergedList.add(iterator.next());
            }
        }
    }
    return mergedList;
}