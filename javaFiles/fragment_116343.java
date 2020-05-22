class SharedEntity {

    @BindMagic
    private List<Map<String, Object>> values;
    private List<Map<String, Object>> valuesCopy;

    public boolean isChangedSincePreviousCall() {
        newCopy = new ArrayList<>(values);
        boolean result = !Objects.equals(valuesCopy, newCopy);
        valuesCopy = newCopy;
        return result;
    }
}