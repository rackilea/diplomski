item = 0;
for (int k = 0; k < arrayQueues.size(); k++) {
    while (!arrayQueues.get(k).isEmpty()) {
        lowercaseArray.set(item++, arrayQueues.get(k).dequeue());
    }
}