class Distance implements Comparable<Distance>{
  /**
    * Compare a given Distance with this object.
    */
    public int compareTo(Distance o) {
        return this.distance(player).compareTo(o.distance(o.player));
    }
}