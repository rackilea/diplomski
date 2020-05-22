public boolean foo(E e, E next) {
  if (e == null) 
      return next == null;
  else 
      return e.equals(next);
}