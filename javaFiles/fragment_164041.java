Set<Integer> seenNumbers = new HashSet<>();
for (int i = 0; i < values.length - 1; i++) {
    int left = values[i];

    if (seenNumbers.contains(right)) {
        continue;
    }

    for (int j = i + 1; j < values.length; j++) {
        int right = values[j];

        if (seenNumbers.contains(right)) {
            continue;
        }

        if (((long)left*(long)right) > k) {
            results.accept(left, right);
            if (left != right) {
                results.accept(right, left);
            }
        }
    }
    seenNumbers.add(left);
}