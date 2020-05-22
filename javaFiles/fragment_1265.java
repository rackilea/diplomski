private boolean hasRoutesDFS(int start, int end) {
    return hasRoutesDFS(start, end, new boolean[graph.size() + 1]);
}

private boolean hasRoutesDFS(int start, int end, boolean[] isVisited) {
    if (start < 0 || start > graph.size() || end < 0 || end > graph.size()) {
        return false;
    }

    if (start == end) {
        return true;
    } else {
        isVisited[start] = true;
        System.out.print(start + "->");
        for (int v : graph.getEdge(start)) {
            if (!isVisited[v]) {
                isVisited[v] = true;
                hasRoutesDFS(v, end, isVisited);
            }
        }

    }

    return false;
}