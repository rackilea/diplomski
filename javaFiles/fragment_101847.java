public <T> boolean equalsInAnyOrder(List<T> sublist, List<T> target) {

    List<String> copy = new ArrayList<>(sublist);
    copy.sort();

    return copy.equals(target);
}