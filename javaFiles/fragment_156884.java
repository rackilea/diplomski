import java.util.ArrayList;

public class SolarSystem {
    private double luminosity;
    private String solarName;
    private ArrayList<Planet> planetList = new ArrayList<>();

    SolarSystem(String solarName, double luminosity) {
        this.solarName = solarName;
        this.luminosity = luminosity;
    }

    public double getLuminosity() {
        return luminosity;
    }

    public void setLuminosity(double luminosity) {
        this.luminosity = luminosity;
    }

    public void setSolarSystem(String solarName, double luminosity) {
        this.solarName = solarName;
        this.luminosity = luminosity;
    }

    public String getsolarName() {
        return solarName;
    }

    public String getsolarname() {
        return solarName;
    }

    public void addPlanet(String name, double mass, double distance) {
        Planet newPlanet = new Planet(name, mass, distance);
        planetList.add(newPlanet);
    }

    public String toString() {
        Planet planet = planetList.get(0);
        return getsolarName() + "\n" + "Planet " + planet.getPlanetname() +
                " has a mass of " + planet.getma() + " Earths, is " +
                planet.getdist() + " from its star, and orbits in " +
                planet.getPeriod() +
                " years: could be habitable? " + planet.getHabitable() + "\n";

    }

    class Planet {
        SolarSystem system;
        private String planetname;
        private double ma;
        private double dist;
        private double period;
        private String habitable;
        private double luminos;
        private double sqlum;

        public Planet(String name, double mass, double distance) {
            setPlanetname(name);
            ma = mass;
            dist = distance;
            setLuminosity(luminos);
            period = java.lang.Math.sqrt(distance * distance * distance);
            sqlum = java.lang.Math.sqrt(luminos);
            if ((ma >= 0.6) && (ma <= 7.0) && (dist >= 0.75 * sqlum) && (dist <= 2.0 * sqlum)) {
                habitable = "yes";

            } else {
                habitable = "no";
            }
        }

        public String getdist() {
            return null;
        }

        public String getma() {
            return null;
        }

        public String getPlanetname() {
            return planetname;
        }

        public void setPlanetname(String planetname) {
            this.planetname = planetname;
        }

        public double getPeriod() {
            return period;
        }

        public void setPeriod(double period) {
            this.period = period;
        }

        public String getHabitable() {
            return habitable;
        }

        public void setHabitable(String habitable) {
            this.habitable = habitable;
        }
    }
}