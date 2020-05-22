public String getMyRequiredValue2(Optional<String> value) {
    try {
        return getAnotherValue(value.get()).orElse(null);
    } catch (NoSuchElementException e) {
        return "Random";
    }
}