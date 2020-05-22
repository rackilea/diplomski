public String getFourOrNull() {
    return somethings.stream()
            .filter(s -> s.getIt().equals("four"))
            .findAny()
            .map(Something::getIt)
            .orElse(null);
}