public final class Spaceship {
    private final int    id;
    private final String name;
    public Spaceship(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public int getId() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
    @Override
    public String toString() {
        return this.id + ":" + this.name;
    }
}

public final class Spacedock {
    private Map<Integer, Spaceship> byId   = new HashMap<>();
    private Map<String, Spaceship>  byName = new TreeMap<>(); // so getSpaceships() lists ordered by name
    public boolean containsSpaceship(Spaceship spaceship) {
        Spaceship shipInDock = this.byId.get(spaceship.getId());
        return (shipInDock != null && shipInDock.getName().equals(spaceship.getName()));
    }
    public void addSpaceship(Spaceship spaceship) {
        if (! containsSpaceship(spaceship)) {
            Spaceship prevShip = this.byId.put(spaceship.getId(), spaceship);
            if (prevShip != null)
                this.byName.remove(prevShip.getName());
            prevShip = this.byName.put(spaceship.getName(), spaceship);
            if (prevShip != null)
                this.byId.remove(prevShip.getId());
        }
    }
    public void removeSpaceship(Spaceship spaceship) {
        if (containsSpaceship(spaceship)) {
            this.byId.remove(spaceship.getId());
            this.byName.remove(spaceship.getName());
        }
    }
    public Collection<Spaceship> getSpaceships() {
        return this.byName.values();
    }
    public Spaceship getById(int id) {
        return this.byId.get(id);
    }
    public Spaceship getName(String name) {
        return this.byName.get(name);
    }
    @Override
    public String toString() {
        return this.byName.values().toString();
    }
}