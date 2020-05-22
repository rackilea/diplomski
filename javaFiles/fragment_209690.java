Collections.sort(managersList, new Comparator<Manager>() {
    @Override
    public int compare(Manager object1, Manager object2) {
        return Integer.compare(object1.getAge(), object2.getAge());
    }
});