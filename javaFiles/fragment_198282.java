Properties tmp = new Properties() {
    @Override
    public synchronized Enumeration<Object> keys() {
        return Collections.enumeration(new TreeSet<Object>(super.keySet()));
    }
};
tmp.putAll(properties);
tmp.store(new FileWriter(file), null);