class QualityControl {
    public static <T> boolean check(java.util.List<T> items) {
        if (items == null || items.isEmpty()) {
            return false;
        }
        return items.stream()
               .noneMatch(b -> (!(b instanceof Box)) 
                          || !(((Box) b).get() instanceof Bakery));
    }
}