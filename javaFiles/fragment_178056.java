/**
   * Appends a value to the end of the array
   * @param val the value to be appended
   * @return the resulting array.
   */
  public ArrayPP add(T val)
  {
     T[] temp = Arrays.copyOf(t, t.length+1);
     temp[t.length] = val;
     t = temp;
     return this;
  }