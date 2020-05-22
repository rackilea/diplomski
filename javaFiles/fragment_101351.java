private enum PickerActions {
    PICK("PICK"),
    PICK_MULTIPLE("PICK_MULTIPLE");
    private final String value;
    PickerActions(final String value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return value;
    }
}

private static boolean test(String test) {
     switch (PickerActions.valueOf(test)) {
        case PICK:
            //
            return true;
        case PICK_MULTIPLE:
            //
            return false;
        default:
            // Log.w(this.LOGGER_TAG, "No function was found for " + test);
            return false;      
    }
}