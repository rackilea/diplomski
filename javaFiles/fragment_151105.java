public static String getRandomStringFromRooms1() {
        Random random = new Random();
        return rooms1[random.nextInt(rooms1.length)];
    }

public static void main(String[] args) {
        addRooms();        
        String roomChosen = getRandomStringFromRooms1();
        while (rooms2.contains(roomChosen))            
            roomChosen = getRandomStringFromRooms1();
        System.out.println("Player has entered the " + roomChosen);
}