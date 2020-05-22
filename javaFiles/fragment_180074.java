static Type getType(final int id) {
    if (types == null) {
        synchronized (CLASSNAME.class) {
            if (types == null) {
                HashMap<Integer, Type> temp = new HashMap<>();
                // populate temp
                types = temp;
            }
        }
    }
    return types.get(id);
}