ArrayList<String> list = getList();
synchronized (list) {
    int index = list.indexOf("test");
    // if the whole block would not be synchronized,
    // the index could be invalid after an external change
    list.remove(index);
}