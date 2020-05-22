public Time getNextTime() {
    if (index >= time.size()) {
        return null;
    }
    return time.get(index++);
}