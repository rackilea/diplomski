public class RoomPriceService {

    private Map<Class<? extends RoomType>, Integer> prices;

    public RoomPriceService(int defaultPrice) {
        this.prices = new HashMap();
    }

    public void setPriceOfRoomType(Room r, Integer price) {
        this.prices.set(r.getClass(), price);
    }

    public Integer getPriceOfRoomType(Room r) {
        // You can expand on this code by adding setters/getters for
        // setting and getting the default room price.
        return this.prices.getOrDefault(r.getClass(), 100);
    }

}