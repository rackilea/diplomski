int[] counters = new int[n]; // i, j, k, ...

while(counters[0] < currentProjectTeam.expertForSkill.get(0).expertList.size()) {
    // Compute projectAndTeam, using loop over counters
    allTeamCombinations.add(projectAndTeam);

    for(int currentDepth = n - 1; ++counters[currentDepth] == currentProjectTeam.expertForSkill.get(currentDepth).expertList.size() && currentDepth > 0; currentDepth--) {
        counters[currentDepth] = 0;
    }
}