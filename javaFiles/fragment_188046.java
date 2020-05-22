public class CollectionUtils {
    private CollectionUtils() {
    }

    /**
     * @return true if A contains B in order
     */
    public static <T> boolean checkAcontainsB(Collection<T> a, Collection<T> b) {
        if (a == null || b == null || b.size()>a.size()) {
            return false;
        }
        if (b.isEmpty()) {
            return true;
        }
        final Object[] aElements = a.toArray();
        final Object[] bElements = b.toArray();

        for (int i = 0; i < aElements.length; i++) {

            int bIndex = 0;
            for(int j = i; j< aElements.length; j++) {
                if(aElements[j] == bElements[bIndex]) {
                    bIndex++;
                    if(bIndex>=bElements.length) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}