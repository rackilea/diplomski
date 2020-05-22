// 1 -> This card is greater
// 0 -> both cards are equal
// -1 -> This card is lesser
public int isGreater(Card cardToCompare) {
    // Check the cardType
    if (this.type < cardToCompare.type) {
        return 1;
    }
    if (this.type == cardToCompare.type) {
        if (this.value < cardToCompare.value) {
            return 1;
        }
        if (this.value == cardToCompare.value) {
            return 0;
        }
        if (this.value > cardToCompare.value) {
            return -1;
        }
    }
    if (this.type > cardToCompare.type) {
        return -1;
    }
}