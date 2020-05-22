@Override
public int compareTo(Card other) {
    int cmp = this.Rank.compareTo(other.Rank);
    if (cmp == 0)
        cmp = this.Suit.compareTo(other.Suit);
    return cmp;
}