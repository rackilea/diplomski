Class<?> type = int.class;
Object array = java.lang.reflect.Array.newInstance(type, 4);

int index = 0;
Object value = getFirstElement();
java.lang.reflect.Array.set(array, index, value);