public Apartment(String city, double area, double price) {
    this.city = city;
    this.area = area;
    this.price = price;
    this.rabat = price * multiplier;
}