public int count(@Nullable Object element) {
    try {
      @SuppressWarnings("unchecked")
          E e = (E) element;
          AvlNode<E> root = rootReference.get();
          if (!range.contains(e) || root == null) {
              return 0;
          }
      return root.count(comparator(), e);
    } catch (ClassCastException e) {
          return 0;
    } catch (NullPointerException e) {
          return 0;
    }
}