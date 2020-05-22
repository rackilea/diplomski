...
List<ErrorObject> errors = new ArrayList<ErrorObject>();
CustomObject[] results = wrapper.retrieve(errors);
if (results == null) {
    for (ErrorObject eo : errors) {
        ...
    }
}