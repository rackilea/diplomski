public class ABListener {

    @PrePersist
    @PreUpdate
    void handleCUpdate(AB ab) {
        if (ab.getB() != null) {
            ab.setC(ab.getB().getC());
        }
    }

}