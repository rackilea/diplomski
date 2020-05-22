private int[] getLevelConstants(int level) {
    int[] result = null;
    TypedArray ta = getResources().obtainTypedArray(R.array.difficulties);
    // keep in mind the differences between the level(starts at 1) and the index of the difficulties array which starts at 0
    int id = ta.getResourceId(level, 0); 
    if (id > 0) {
        result = getResources().getIntArray(id);
    } else {
        // something bad
    }
    return result;
}