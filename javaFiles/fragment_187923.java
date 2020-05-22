3035    public static <T,U> T[] More ...copyOfRange(U[] original, int from, int to, Class<? extends T[]> newType) {
3036        int newLength = to - from;
3037        if (newLength < 0)
3038            throw new IllegalArgumentException(from + " > " + to);
3039        T[] copy = ((Object)newType == (Object)Object[].class)
3040            ? (T[]) new Object[newLength]
3041            : (T[]) Array.newInstance(newType.getComponentType(), newLength);
3042        System.arraycopy(original, from, copy, 0,
3043                         Math.min(original.length - from, newLength));
3044        return copy;
3045    }