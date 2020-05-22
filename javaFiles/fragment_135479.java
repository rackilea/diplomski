TreeSet<Device> devices = new TreeSet<>(new Comparator<Device>() {
    @Override
    public int compare(Device o1, Device o2) {
        return o1.getNumber().compareTo(o2.getNumber());
    }
});