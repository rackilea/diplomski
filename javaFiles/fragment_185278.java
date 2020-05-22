public class TestPlanets {
    public static void main (String [] args) {

        Planet earth = new Planet("Earth", 2, "Blue", 47000);
        Planet pluto = new Planet("Pluto", 9, "Blue", 47000);
        Planet mars = new Planet("Mars", 5, "Blue", 47000);
        Planet venus = new Planet("Venus", 1, "Blue", 47000);

        // make an list of the planets: (called planets)
        ArrayList<Planet> planets = new ArrayList<Planet>();
        planets.add(earth);
        planets.add(pluto);
        planets.add(mars);
        planets.add(venus);

        // and now magic:
        for (int i = 0; i < planets.size(); i++) {
            System.out.println(planets.get(i).toString());
        }
    }
}