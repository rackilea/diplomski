@RequestMapping(value="/hotels/{hotel}/bookings/{booking}", method=RequestMethod.GET)
public String getBooking(@PathVariable("hotel") long hotelId, @PathVariable("booking") long bookingId, Model model) {
    Hotel hotel = hotelService.getHotel(hotelId);
    Booking booking = hotel.getBooking(bookingId);
    model.addAttribute("booking", booking);
    return "booking";
}