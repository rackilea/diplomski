// unbounded T
@SuppressWarnings("unchecked")
T[] array = (T[]) new Object[size];

// or if, for instance, T is upper-bounded by CharSequence
@SuppressWarnings("unchecked")
T[] array = (T[]) new CharSequence[size];

// or if the component type is itself generic
@SuppressWarnings("unchecked")
Comparator<String>[] array = (Comparator<String>[]) new Comparator[size];