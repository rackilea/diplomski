protected synchronized TimeSlot nextSlot() {
    if (slot == null) {
        slot = new TimeSlot();
    }
    if (slot.isFull() || !slot.isActive()) {
        slot = slot.next();
    }
    slot.assign();
    return slot;
}