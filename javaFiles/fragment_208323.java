<T> void reverse(List<T> list)
{
    List<T> reversed = new ArrayList<T>();
    for (int i = list.size(); i > 0; i--) {
        reversed.add(list.get(i - 1));
    }
    list.clear();
    list.addAll(reversed);
}