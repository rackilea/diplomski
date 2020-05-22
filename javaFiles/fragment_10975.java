// Use a for-each loop to go through all of the items in toBeAdded
for (E c : toBeAdded) {

    // If c is already in the ArrayCollection, continue
    if (this.contains(c)) {
        continue;
    }

    // If c isn’t already in the ArrayCollection, add it
    this.add(c);

    stuffAdded = true;
}