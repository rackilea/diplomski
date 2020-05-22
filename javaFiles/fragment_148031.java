private static class ClassNameComparator implements Comparator<Class<?>>, Serializable {

    private static final long serialVersionUID = 1L;

    ClassNameComparator() {
    }

    @Override
    public int compare(Class<?> first, Class<?> second) {
        String firstCanonicalName = first.getCanonicalName();
        String secondCanonicalName = second.getCanonicalName();
        if (firstCanonicalName != null && secondCanonicalName != null) {
            return firstCanonicalName.compareTo(secondCanonicalName);
        } else {
            return first.getSimpleName().compareTo(second.getSimpleName());
        }
    }
}