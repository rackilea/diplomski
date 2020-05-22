public static <T> Pair<T, Integer> mode(T items[]) {
    if (items == null || items.length == 0) {
        throw new RuntimeException("Empty array has no mode");
    } else {
        T element = items[0];
        int count = 0;

        for(int i = 0; i < items.length; i++) {
            int tempCount = 0;
            T tempElement = items[i];

            for(int j = 0; j < items.length; j++) {
                if (tempElement.equals(items[j])) {
                    tempCount++;
                }
            }   
            if (tempCount > count) {
                count = tempCount;
                element = tempElement;
            }
        }
        return new Pair<T, Integer>(element, new Integer(count));
    }
    return null;
}