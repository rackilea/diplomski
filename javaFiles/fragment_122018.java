public class Arsenal{
    private Map<Class<?>, Collection<?>> weaponArsenal;

    public <T extends Weapon> Collection<T> get(Class<T> weaponClass) {
        if (weaponArsenal.containsKey(weaponClass) {
            return (Collection<T>) weaponArsenal.get(weaponClass);
        }
        return new ArrayList<T>(); // to avoid checking null everytime in client code
    }

    public <T extends Weapon> void put(T weapon) {
        if (!weaponArsenal.containsKey(weapon.class)) {
            Collection<T> weaponList = // initialize correct collection here
            weaponArsenal.put(weapon.class, weaponList);
        }

        weaponArsenal.get(weapon.class).add(weapon);
    }
}