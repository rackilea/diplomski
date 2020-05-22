@Entity
public class StoreComission extends Model {

    public StoreComission() {
        id = new ComissionId();
    }

    @EmbeddedId
    private ComissionId id;

    @Column(nullable = false)
    public double value;

    @Column(nullable = false)
    public Date date;

    @ManyToOne
    @JoinColumn(name = "booking_id", insertable = false, updatable = false)
    private Booking booking;

    @ManyToOne
    @JoinColumn(name = "store_id", insertable = false, updatable = false)
    private Store store;

    public void setBooking(Booking aBooking) {
        booking = aBooking;
        id.booking_id = aBooking.id;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setStore(Store aStore) {
        store = aStore;
        id.store_id = aStore.id;
    }

    public Store getStore() {
        return store;
    }
}