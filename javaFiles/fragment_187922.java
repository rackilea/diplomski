2770
2771    public static <T,U> T[] More ...copyOf(U[] original, int newLength, Class<? extends T[]> newType) {
2772        T[] copy = ((Object)newType == (Object)Object[].class)
2773            ? (T[]) new Object[newLength]
2774            : (T[]) Array.newInstance(newType.getComponentType(), newLength);
2775        System.arraycopy(original, 0, copy, 0,
2776                         Math.min(original.length, newLength));
2777        return copy;
2778    }