public Time getNextTime() {
    if (index < time.size()) {
        return time.get(index++);
    }
    throw new IllegalStateException("Blah blah blah");
}