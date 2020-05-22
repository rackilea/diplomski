while (!queue.isEmpty()) {
    String current = queue.remove();
    path.add(current);

    visited.add(current);

    if (current == end) {
        return path;
    }

    Iterator<String> neighbors = getNeighbors(start).iterator();
    while (neighbors.hasNext()) {
        String n = neighbors.next();

        if (!visited.contains(n)) {
            queue.add(n);
        }
    }
}