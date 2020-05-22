for (Iterator<PopulationMember> it = population.iterator(); it.hasNext();) {
    PopulationMemeber p = it.next();
    int[] probs = ProbablityArrayDeath(GrowthRate,Death,(int)p.fitness());
    if (probs[RandomNumberGen.nextRandomInt(0, 99)] == 0) {
        it.remove();
    }
}