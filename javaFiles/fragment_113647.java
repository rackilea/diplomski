// Given a list of FlashCard objects
final List<FlashCard> cards = ...

// Convert to stream, and collect them by category. 
final Map<String, List<FlashCard>> byCategory = cards.stream()
            .collect(Collectors.groupingBy(FlashCard::getCategory));