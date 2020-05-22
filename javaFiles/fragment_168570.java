private BookingDetail  bookingDetail;

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "booking_details_id")
public BookingDetail getBookingDetail() {
        return bookingDetail;
}

public void setBookingDetail(BookingDetail bookingDetail) {
        this.bookingDetail = bookingDetail;
}