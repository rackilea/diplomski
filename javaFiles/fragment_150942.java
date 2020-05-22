public static Comparator<Container> DEPARTURE = new Comparator<Container>() {
    @Override
    public int compare(Container container1, Container container2) {
        int rv;

        // Times
        rv = container1.departure.time.compareTo(container2.departure.time);
        if (rv == 0) {
            // Duration
            if (container1.departure.maxDuration < container2.departure.maxDuration) {
                rv = -1;
            }
            else if (container1.departure.maxDuration > container2.departure.maxDuration) {
                rv = 1;
            }
            else {
                // Transport company
                rv = container1.departure.transportCompany.compareTo(container2.departure.transportCompany);
                if (rv == 0) {
                    // Transport type
                    rv = container1.departure.transportType.compareTo(container2.departure.transportType);
                }
            }
        }
        return rv;
    }
};