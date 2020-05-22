List<List<String>> messages = parseMessages(getPath());

String needle = "uan:123";
List<List<String>> messagesWithNeedle = messages.stream()
    .filter(message -> message.contains(needle))
    .collect(Collectors.toList());