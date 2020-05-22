public V retrieveUsingStreams(K key) {
    return set_of_pairs.stream()
            .filter(pair -> pair.getKey().equals(key)) // the 'if' check
            .findFirst() // the 'return' in your iterations
            .map(Pair::getValue) // value based on the return type
            .orElse(null); // else returns null
}