enum CardStatus {
    UNKNOWN, // 0 should map to this
    PENDING, // 1 should map to this
    ACTIVE; // 2 should map to this

    public static CardStatus getCardStatus(int cardStatus) {
        return CardStatus.values()[cardStatus];
    }
}