private static final OptionalComparator<? extends Comparable<?>> ABSENT_FIRST = new AbsentFirst<>();

private static final OptionalComparator<? extends Comparable<?>> ABSENT_LAST = new AbsentLast<>();

private interface OptionalComparator<T extends Comparable<T>> extends Comparator<Optional<T>> { }

private static class AbsentFirst<T extends Comparable<T>> implements OptionalComparator<T> {
    @Override
    public int compare(Optional<T> obj1, Optional<T> obj2) {
        if (obj1.isPresent() && obj2.isPresent()) {
            return obj1.get().compareTo(obj2.get());
        } else if (obj1.isPresent()) {
            return -1;
        } else if (obj2.isPresent()) {
            return 1;
        } else {
            return 0;
        }
    }
}

private static class AbsentLast<T extends Comparable<T>> implements OptionalComparator<T> {
    @Override
    public int compare(Optional<T> obj1, Optional<T> obj2) {
        if (obj1.isPresent() && obj2.isPresent()) {
            return obj1.get().compareTo(obj2.get());
        } else if (obj1.isPresent()) {
            return 1;
        } else if (obj2.isPresent()) {
            return -1;
        } else {
            return 0;
        }
    }
}

static <T extends Comparable<T>> OptionalComparator<T> absentFirstComparator() {
    @SuppressWarnings("unchecked")
    OptionalComparator<T> comp = (OptionalComparator<T>) ABSENT_FIRST;
    return comp;
}

static <T extends Comparable<T>> OptionalComparator<T> absentLastComparator() {
    @SuppressWarnings("unchecked")
    OptionalComparator<T> comp = (OptionalComparator<T>) ABSENT_LAST;
    return comp;
}

public static void main(String... args) {
    OptionalComparator<Integer> absentFirstInt = absentFirstComparator();
    System.out.println(absentFirstInt.compare(Optional.of(1), Optional.empty()));

    OptionalComparator<Integer> absentLastInt = absentLastComparator();
    System.out.println(absentLastInt.compare(Optional.of(1), Optional.empty()));

    OptionalComparator<Double> absentFirstDouble = absentFirstComparator();
    System.out.println(absentFirstDouble.compare(Optional.of(1.0), Optional.empty()));

    OptionalComparator<Double> absentLastDouble = absentLastComparator();
    System.out.println(absentLastDouble.compare(Optional.of(1.0), Optional.empty()));
}