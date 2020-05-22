@Override
  public boolean equals(Object obj) {
    if (!(obj instanceof FiguresGroup)) {
      return false;
    }
    FiguresGroup other = (FiguresGroup) obj;
    return numF == other.numF && other.included(this) && this.included(other);
  }