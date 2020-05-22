float total = 0;
for (final Integer wordCount : freqMap.values()) {
    total += wordCount;
}
// ...
    final float percentage = (value / total) * 100;