public class Room {
    private static Map<Class<? extends Room>, Integer> prices =
            new HashMap<>();

    public final int getRoomBasePrice() {
        // If a Room subclass does not have a specific base price, return
        // 1000 by default.
        return Room.prices.getOrDefault(this.getClass(), 1000);
    }

    /** Sets the base price for the specified Room type.
     */
    public final void setRoomBasePrice(int price) {
        Room.prices.put(this.getClass(), price);
    }
}