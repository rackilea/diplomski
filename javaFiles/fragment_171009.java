if(this.homeChests == null) {
    this.homeChests = new HashSet<>(homeChests);
}
else {
    // very simply, you possibly better sync the new elements in...
    this.homeChests.addAll(homeChests);
}