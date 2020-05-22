// find smallest costs[i] smaller than current:
int smallestCostIndex = -1;
int smallestCost = Integer.MAX_VALUE;
for (int i = level + 1; i <= maxLevel; i++) {
    if (current >= costs[i] && costs[i] < smallestCost) {
        smallestCost = costs[i];
        smallestCostIndex = i;
    }
}
// calculate first using smallest costs[i] smaller than current (if it exists):
int first = Integer.MAX_VALUE;
if (smallestCostIndex >= 0) {
    first = fork(current - costs[i], required, i, taps, values, costs, maxLevel, cache);
}