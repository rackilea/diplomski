Set<String> oldData = new HashSet<>();
try (BufferedReader reader = Files.newBufferedReader(Paths.get("oldData"))) {
    for (String line = reader.readLine(); line != null; line = reader.readLine()) {
        // process your line, maybe add to the Set for the old data?
        oldData.add(line);
    }
}

Set<String> newData = new HashSet<>();
try (BufferedReader reader = Files.newBufferedReader(Paths.get("newData"))) {
    for (String line = reader.readLine(); line != null; line = reader.readLine()) {
        // Is it enough just to remove from old data so that you'll end up with only the difference between old and new?
        boolean oldRemoved = oldData.remove(line);
        if (!oldRemoved) {
            newData.add(line);
        }
    }
}