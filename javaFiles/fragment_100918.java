//...
private static void save(String[] hotel) {
    try {
        FileLoad.writeHotelArray("data.txt", hotel);
    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("No such file exists.");
    }
}

public static String[] load() {
    String file = "data.txt";
    String[] hotelArray = null;
    try {
        hotelArray = FileLoad.readHotelArray(file);
    } catch (IOException e) {
        System.out.println("Unable to create " + file + ": " + e.getMessage());
    }
    return hotelArray;
}
//...