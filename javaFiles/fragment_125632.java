protected void writeObjectOverride(Object obj) throws IOException {
    if (isMySpecialClass(obj.getClass())) {
        // call writeOrdinaryObject(obj, desc, unshared); using reflection because this method is private
        return;
    }
    // fall back to regular mechanism.
}