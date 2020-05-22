private <T> T getNext(Class<T> type) {
    for (Actor a : getActors()) {
        if (type.isAssignableFrom(a.getClass())) {
            return (T) a;
        }
    }
    return null; //or type.newInstance(); if you want a guaranteed object, but this restricts your constructor.
}