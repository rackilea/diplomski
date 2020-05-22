public static void deleteHotel(String hotelName) {
    for (int i = 0; i < hotels.length; i++) {
        if (hotels[i].getName().equalsIgnoreCase(hotelName)) { //searches the array, looking for the object that has the inputted name
            hotels[i] = null; //makes that object null
            for (int x = i; x < hotels.length -1; x++) 
                hotels[x] = hotels[x + 1]; //makes that null position point to the next position that has an object, and then that position points to the object in the next position and so on

            Hotel[] hoteisTemp = new Hotel[hotels.length - 1];
            for(int x = 0; x < hotels.length - 1; x++) //create a new array with one less position, and then copy the objects on the old array into the new array, then point the old array to the new array
                hoteisTemp[x] = hotels[x];

            hotels = hoteisTemp;
            break;
        }
    }
}