// positive result -> this card is greater
// 0 -> cards are equal
// negative result -> cardToCompare is greater
public int isGreater(Card cardToCompare) {
    return cardToCompare.value - this.value;
}