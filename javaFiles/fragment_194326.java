@Override
 public void addColumn(Object columnName) {
       Class[] temp = new Class[types.length +1];
       System.arraycopy(types, 0, temp, 0, types.length);
       temp[types.length] = Double.class;
       types = temp;
       super.addColumn(columnName);
 }