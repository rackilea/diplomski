static List<NumberObject> findLongestPath(NumberObject currentNode) {
        if (currentNode.getConnectedNodes().isEmpty()) {
            List<NumberObject> result = new ArrayList<>();
            result.add(currentNode);
            return result;
        }

        List<NumberObject> longestPath = currentNode.getConnectedNodes().stream()
                .map(PathFinder::findLongestPath)
                .max(Comparator.comparing(List::size))
                .get();

        longestPath.add(currentNode);
        return longestPath;
    }