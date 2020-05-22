public static <T> void reverse(List<T> a_list) {
    int list_size = a_list.size();
    ListIterator<T> left_to_right = a_list.listIterator();
    ListIterator<T> right_to_left = a_list.listIterator(list_size);
    T temp_variable;

    while(left_to_right.nextIndex() < list_size / 2) {
        temp_variable = left_to_right.next();
        left_to_right.set(right_to_left.previous());
        right_to_left.set(temp_variable);
    }
}