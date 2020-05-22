class HotelServiceImpl implements HotelService {

    // …

    @Override
    public Mono<Hotel> save(Hotel hotel) {
        if (hotel.getId() == null) {
            hotel.setId(UUID.randomUUID());
        }
        Mono<Hotel> saved = hotelRepository.save(hotel);
        return saved.then(hotelByLetterRepository.save(new HotelByLetter(hotel)));
    }
}