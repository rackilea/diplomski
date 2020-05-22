// method argument is just for the sake of an example and clarification here 
public String getSanitisedMessage(Throwable rootCause, Set<String> primaryCauses) {
    return Optional.ofNullable(rootCause)
            .map(Throwable::getMessage)
            .map(String::toLowerCase)
            .flatMap(message -> primaryCauses.stream()
                    .map(String::toLowerCase)
                    .filter(message::contains)
                    .findFirst())
            .orElse("NA");
}