// public facing method where clients should not be able to modify list    
public List<Bean> getImmutableList(int size) {
    return Collections.unmodifiableList(getMutableList(size));
}

// private internal method (to be used from main in your case)
private List<Bean> getMutableList(int size) {
    List<Bean> beanList = new ArrayList<Bean>();
    int i = 0;

    while(i < size) {
        Bean bean = new Bean("name" + i, "address" + i, i + 18);
        beanList.add(bean);
        i++;
    }
    return beanList;
}