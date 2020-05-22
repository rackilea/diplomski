public T[][] generation(int size, T[] values) {
  result = (T[][]) Array.newInstance(values.getClass().getComponentType(),
      values.length, size);
  generator(0, 0);
  return result;
}