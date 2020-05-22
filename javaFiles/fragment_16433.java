class ListAdder<T, L extends List<T>> {
  L list;

  ListAdder(L list) { this.list = list; }

  L list() { return list; }

  ListAdder<T> add(T item) { list.add(item); return this; }
}