public E getInstance(String msg, Throwable t) { 
  final Constructor<E> localTwo = two;
  if (null == localTwo) {
    return (E)one.newInstance(msg).initCause(t);
  }
  return localTwo.newInstance(msg, t);
}