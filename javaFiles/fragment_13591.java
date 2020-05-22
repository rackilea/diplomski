new ChoiceRenderer<Action>() {
    @Override
    public Object getDisplayValue(Action object) {
        return object.getDisplayName(); //return any string describing the object
    }
}