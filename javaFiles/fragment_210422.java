public class Test {

    public static void main(String[] args) {
        String json = ...
        ObjectMapper mapper = new ObjectMapper();
        Cities cities = mapper.readValue(json, Cities.class);
        for(City city : cities) {
            System.out.println(city.getName());
            for(Office office : city.getOffices()) {
                System.out.println("\t" + office.getName());
                for(Room room : office.getRooms()) {
                    System.out.println("\t\t" + room.getName());
                    System.out.println("\t\t\t" + room.getPropertyTwo());
                }
            }
        }
    }
}