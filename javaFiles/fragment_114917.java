public interface IGang {
    /** @return negative, 0, or positive, respectively
     *          if this gang is weaker than, equal to, or stronger
     *          than the other
     */
    public int compareTo(IGang g);
}