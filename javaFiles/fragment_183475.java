@Override
public int compareTo(Card otherCard) {
    if (this.rank == otherCard.rank) {
       return this.suite.compareTo(otherCard.suite);
    }
    return this.rank.compareTo(otherCard.rank);
}