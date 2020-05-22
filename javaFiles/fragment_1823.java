class callPro {

    private static String name;
    private static String city;
    private static String address;

    public static void main(String[] args) {
        // create prop instance
        prop property = new prop();

        // call prop's method getValue()
        name = property.getValue(prop.property.CITY);
        city = property.getValue(prop.property.NAME);
        address = property.getValue(prop.property.ADDRESS);
        // New York, John, Central Park
        System.out.println(name + ", " + city + ", " + address);
    }
}