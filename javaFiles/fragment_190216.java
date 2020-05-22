for (Iterator<String> iterator = source.iterator(); iterator.hasNext(); ) {
    String element = iterator.next();
    if (shouldDrain(element)) {
        destination.add(element);
        iterator.remove();
    }
}