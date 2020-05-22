class Session {
    private LocalDateTime start;
    private LocalDateTime end;  

    public boolean isOverlapped(Session other) {
        return (start.isBefore(other.end) || start.equals(other.end)) 
            && (end.isAfter(other.start) || end.equals(other.start));
    }
    ...     
}