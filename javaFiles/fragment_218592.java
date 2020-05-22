public void doThings(Map<Constraint, Object> map) {
    for (Entry<Constraint, Object> entry: map.entrySet()) {
        if (entry.getKey().isValid()) {
            Object obj = entry.getValue();
            // Do whatever you want with the object
        }
    }
}