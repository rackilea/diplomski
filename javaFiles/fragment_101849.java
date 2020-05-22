public <T> boolean equalsInAnyOrder(List<T> sublist, List<T> target) {

    List<String> copy = new ArrayList<>(sublist);
    Collections.sort(copy);

    return copy.equals(target);
}