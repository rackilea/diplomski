public void countAndInsert(String sentence) {
    int fCount = 0;
    for (char c : sentence.toCharArray()) {
        if (c == 'F' || c == 'f') {
            fCount++;
        }
    }

    heap.insert(sentence, fCount);
}