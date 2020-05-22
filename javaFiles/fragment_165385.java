public boolean isBookable(Booking wishedBooking) {

    boolean bookable = false;

    if ((wishedBooking.begin.compareTo(begin) <= 0
            && wishedBooking.end.compareTo(begin) <= 0)
            || (wishedBooking.begin.compareTo(end) >= 0
                && wishedBooking.end.compareTo(end) >= 0)) {
        bookable = true;
    }

    return bookable;             
}