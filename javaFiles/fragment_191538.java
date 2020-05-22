food = new SelectItem[hotels.size()];

for (int i = 0; i < hotels.size(); i++) {
    Hotel hotel = hotels.get(i);
    food[i] = new SelectItem(hotel.getId(), hotel.getName());
}