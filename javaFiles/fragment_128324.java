@Override
protected String newValue(String currentValue, String valueToRemove) {
    if (currentValue == null) return "";

    Set<String> classes = Sets.newHashSet(Splitter.on(" ").split(currentValue));
    classes.remove(valueToRemove);
    return Joiner.on(" ").join(classes); 
}