public float calculatePercentage(Float count) {
    Float totalF = total.get();
    if(totalF == null)
        return -1;

    return count / totalF;
}