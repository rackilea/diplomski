private final List<Integer> invocations = new ArrayList<>();

public int newNumber(final int i) {
    if (!this.invocations.contains(i)) {

        // Not seen before, so add to the List, and return -1.
        this.invocations.add(i);
        return -1;
    }

    // size - 1 for 0 indexed list.
    // - last index of it since that was the last time it was called.
    final int lastInvocation
            = this.invocations.size() - 1 - this.invocations.lastIndexOf(i);

    // Remove all prior occurrences of it in the List.
    // Not strictly necessary, but stops the List just growing all the time.
    this.invocations.removeIf(value -> value.equals(i));

    // Add the element as the latest invocation (head of the List)
    this.invocations.add(i);
    return lastInvocation;
}