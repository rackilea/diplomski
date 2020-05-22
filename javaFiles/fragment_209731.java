for (int i = level + 1; i <= maxLevel; i++) {
    if (current >= costs[i]) {
        first = fork(current - costs[i], required, i, taps, values, costs, maxLevel, cache);
        break;
    }
}