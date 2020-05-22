public static String getRandomStringFromRooms1(Random random) {

        return rooms1[random.nextInt(rooms1.length)];
}

public static void main(String[] args) {
        addRooms();     
        Random random = new Random();
        String roomChosen = getRandomStringFromRooms1(random);
        while (rooms2.contains(roomChosen))            
            roomChosen = getRandomStringFromRooms1(random);
        System.out.println("Player has entered the " + roomChosen);
}