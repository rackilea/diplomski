public static void dfs(State s, Town last, State best) {
    s.path.add(last);
    s.unused.remove(last);
    if (unused.empty()) {
        // all towns visited - distance and path are now complete
        if (best == null || s.dist < best.dist) best = s;
        return;
    }
    for (Town t : s.unused) {
        State next = s.copy(); // a copy of State s
        next.dist += distBetween(last, t);
        dfs(next, t);
    }
}