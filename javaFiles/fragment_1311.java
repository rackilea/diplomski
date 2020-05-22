public class Driver {
    public static void main(String[] args) {
        ArrayList<Alien> alienList = new ArrayList<>();
        alienList.add(new Martian("Mars", "148", "Zornok", "red", "Read minds"));
        alienList.add(new Saturner("Saturn", "89", "Hookman", "pitch black ", "Go invisible"));
        alienList.add(new Martian("Mars", "18", "Guthrax", "gray", "Teleport"));
        alienList.add(new Saturner("Saturn", "300", "Lamron", "blue", "Fly\n"));

        List<String> planets = Arrays.asList(new String[] {"Earth", "June", "Mercury", "Venus", "Neptune"});
        List<InvadingStrategy> methods = Arrays.asList(new InvadingStrategy[]{new MissileStrategy(),new WaterSystemDestructionStrategy(),new BurningStrategy(),new FloodingStrategy()});

        int i = 0;
        for(Alien alien : alienList){
            alien.invade(planets.get(i) , methods.get(i));
            i++;
        }
    }
}