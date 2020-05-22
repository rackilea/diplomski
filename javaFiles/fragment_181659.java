public void doMapOperation(Object... keys) {
    ArrayList<Object> contained = new ArrayList<Object>();
    ArrayList<Object> missing = new ArrayList<Object>();

    synchronized (synchronizedMap) {
        if (synchronizedMap.containsKey(key)) {
            contained.add(synchronizedMap.get(key));
            synchronizedMap.remove(key);
        } else {
            missing.add(synchronizedMap.get(key));
            synchronizedMap.put(key, value);
        }
    }

    for (Object o : contained)
        o.doExpensiveOperation();
    for (Object o : missing)
        o.doAnotherExpensiveOperation();
}