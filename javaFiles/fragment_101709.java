public class Shipyard {
    private Map<String, Ship> shipsByNameMap = new HashMap<String, Ship>();

    public void registerShipByName(String name, Ship ship){
        shipsByNameMap.put(name, ship);
    }

    public Ship getShipByName(String name){
        return shipsByNameMap.get(name);
    }
}