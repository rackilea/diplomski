// Optional indicates a potentially absent value, it's just a wrapper around a Runnable
Optional<Runnable> optional = MAPPING
    // create a Stream from the entries
    .entrySet().stream()
    // keep the items that match the condition and drop every other
    .filter(e -> filename.startsWith(e.getKey()))
    // we had Map.Entry<String, Runnable>, but now we only need the value e.g. the Runnable
    .map(Map.Entry::getValue)
    // short circuit, e.g. we only want the first value that matches
    .findFirst();

// checks if anything is present, this is used as the MAPPING "could" be empty
if(optional.isPresent()) {
    // unpack the value and call it with arguments
    optional.get().run(aWriter, someFileName, anInputStream);
} else {
    // nothing matched, throw error or log etc.
}