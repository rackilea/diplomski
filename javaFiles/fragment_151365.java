public class Garden {
    public static final Garden GARDEN = new Garden();
    private HashMap<String, Hive> hiveMap = new HashMap<String, Hive>();
    private Garden() {
        // create garden here
    }
    public HashMap<String, Hive> getHiveMap() {
        return this.hiveMap;
    }
}