public Tracker clone() {
  try {
    Tracker newTracker = (Tracker) super.clone();
    newTracker.player = player.clone();
    return newTracker;
  } catch (CloneNotSupportException e){
  }
  return null;
}