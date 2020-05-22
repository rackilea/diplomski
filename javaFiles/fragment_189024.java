public void addAorB(Something instance){
        Set<? extends Something> set = sets.get(instance.getClass());
        if (set == null)
            set = createAndPut(instance.getClass());
        ((Set<Something>) set).add(instance);
}