@Override
public void validate(String entity) throws ClientException {
    String message = !isNameValid(entity.getName()) ? "Invalid name!"
            : !isPhoneValid(entity.getPhone()) ? "Invalid phone number!" : "";
    Stream.of(message).filter(m -> m.isEmpty()).findAny()
            .orElseThrow(() -> new ClientException (message));
}