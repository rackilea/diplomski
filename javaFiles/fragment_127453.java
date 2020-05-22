public <T> void setList(List<T> list, Class<T> clazz) {
    for (T t : list) {
        if(!clazz.equals(t.getClass())) {
            throw new YourPreferedKindOfException();
        }
    }
    this.list = list;
}