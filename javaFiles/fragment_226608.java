ArrayList<Object> list = ...;
for (Object o : list) {
    if (o instanceof Integer)) {
        handleInt((Integer o).intValue());
    }
    else if (o instanceof String)) {
        handleString((String)o);
    }
    ...
}