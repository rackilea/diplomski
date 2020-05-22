String username = view.getField("username", REQUIRED, MINLENGTH(3));
String email = view.getField("email", REQUIRED, EMAIL);
Integer age = view.getField("age", Integer.class, NUMBER);

// ...

public String getField(String name, Validator... validators) {
    return getField(name, String.class, validators);
}

public <T extends Object> T getField(String name, Class<T> type, Validator... validators) {
    String value = request.getParameter(name);
    return validateAndConvert(name, value, type, validators);
}

private <T extends Object> T validateAndConvert
    (String name, String value, Class<T> type, Validator... validators)
{
    value = (value != null && !value.trim().isEmpty()) ? value.trim() : null;
    try {
        for (Validator validator : validators) {
            validator.validate(value);
        }
    } catch (ValidatorException e) {
        setError(name, e.getMessage());
    }
    return (value != null) ? Converter.convert(value, type) : null;
}