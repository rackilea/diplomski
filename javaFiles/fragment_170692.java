Message[] process(@Nullable Message[] messages) {
    if (messages == null || messages.length == 0) return new Message[0];

    List<Function> transformationsToApply = transformations.stream()
            .filter(transformation -> transformationIsEnabled(transformation.getLeft()))
            .map(Pair::getRight)
            .collect(Collectors.toList());

    return Arrays.stream(messages)
            .filter(Objects::nonNull)
            .map(agentMessage -> {
                transformationsToApply.forEach(transformation -> processMessage(transformation, agentMessage));
                return agentMessage;
            })
            .toArray(Message[]::new);
}