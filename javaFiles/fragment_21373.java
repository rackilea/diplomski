private static int makePath(final HashMap<String, String[]> tree, final String from, final String to) {

        int path = 0;
        Queue<String> firstQueue = new PriorityQueue<>();
        Queue<String> secondQueue = new PriorityQueue<>();
        firstQueue.add(from);

        while (!firstQueue.isEmpty()) {
            String key = firstQueue.poll();
            String[] neighbors = tree.get(key);
            if (neighbors != null) {
                path++;
                for (String neighbor : neighbors) {
                    if (neighbor.equals(to)) {
                        return path;
                    } else {
                        secondQueue.add(neighbor);
                    }
                }
            }

            while (!secondQueue.isEmpty()) {
                key = secondQueue.poll();
                neighbors = tree.get(key);
                if (neighbors != null) {
                    path++;
                    for (String neighbor : neighbors) {
                        if (neighbor.equals(to)) {
                            return path;
                        } else {
                            firstQueue.add(neighbor);
                        }
                    }
                }

            }

        }
        return 0;
    }