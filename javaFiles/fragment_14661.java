public static boolean linearIn(int[] outer, int[] inner) {
    boolean isAppear;
    for (int i = 0; i < inner.length; i++) {
        isAppear = false;
        for (int j = 0; j < outer.length; j++) {
            if (outer[j] == inner[i])
                isAppear = true;
        }
        if(!isAppear)
            return false;
    }
    return true;
}