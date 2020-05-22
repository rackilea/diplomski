public Collection<Class<U>>  getEnabledClasses(<JCheckBox,Class<U>> checkMap) {
    List<Class<U>> result = new LinkedList<Class<U>>();
    for (Map.Entry<JCheckBox,Class<U>> entry:checkMap.entrySet()) {
        if (entry.getKey().isSelected()) {
            result.add(entry.getValue());
        }
    }
}