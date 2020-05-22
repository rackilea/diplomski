@Override
public boolean equals(Object obj) {
  Train train = (Train) obj;
  if (this.villeArrivee.equals(train.getVilleArrivee()) && this.villeDepart.equals(train.getVilleDepart())) {
    return true;
  } else {
    return false;
  }
}