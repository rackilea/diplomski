@Embeddable
public class ComissionId {

    public int booking_id;

    public int store_id;

    @Override
    public int hashCode() {
        return booking_id + store_id;
    }

    @Override
    public boolean equals(final Object obj) {
        return super.equals(obj);
    }
}