while (iterator.hasNext()) {
    Type t = iterator.next();
    if (clazz.isAssignableFrom(t.getClass())) {
        list.add(t)
    }       
}