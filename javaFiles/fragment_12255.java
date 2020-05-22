public void addMultiplier(List<String> multipliers) {
    if (this.multipliers != null) {
        this.multipliers.addAll(multipliers);
    } else {
        this.multipliers = multipliers;
    }
}