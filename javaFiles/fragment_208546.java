int levenshteinDistance(List<Vertex> path, int lenPath, List<Vertex> other, int lenOther) {
    if (path.equals(other)) return 0;
    if (lenPath == 0) return lenOther;
    if (lenOther == 0) return lenPath;

    int cost;
    if (path.get(lenPath - 1).equals(other.get(lenOther - 1))) {
        cost = 0;
    } else {
        cost = 1;
    }

    int dist1 = levenshteinDistance(path, lenPath - 1, other, lenOther) + 1;
    int dist2 = levenshteinDistance(path, lenPath, other, lenOther - 1) + 1;
    int dist3 = levenshteinDistance(path, lenPath - 1, other, lenOther - 1) + cost;
    return Math.min(dist1, Math.min(dist2, dist3));
}