@Override 
public boolean equals(Object o) {
    if (o instanceof Event) {
        Event that = (Event) o;
        return Objects.equals(this.eventDate, that.eventDate) &&
               this.eventType == that.eventType &&
               Objects.equals(this.productId, that.productId);
    }
    return false;
}

@Override 
public int hashCode() {
    return Objects.hash(eventDate, eventType, productId);
}