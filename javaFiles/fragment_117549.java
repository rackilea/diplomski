public void run() {
    for (Iterator<Map.Entry<String,Integer>> i = playerCooldowns.entrySet().iterator(); i.hasNext();) {
        Map.Entry<String,Integer> entry = i.next();
        entry.setValue(entry.getValue() - 20); // update via the Map.Entry
        if (entry.getValue() <= 0) {
            i.remove(); // remove via the iterator
        }
    }
}