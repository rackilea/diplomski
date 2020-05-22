public class GameType implements MapSerializable {

    ////////////////////////////////////////////////////////////////////////////
    //private variables
    private String displayName = null;

    ////////////////////////////////////////////////////////////////////////////
    //constrcutor
    public GameType(String name) {
        this.displayName = name;
    }

    GameType() {
    }

    ////////////////////////////////////////////////////////////////////////////
    //public methods
    @Override
    public int populateSerialMap(HashMap<String, Object> serial) throws IOException {
        serial.put("displayName", displayName);
        return 17 * Objects.hashCode(displayName);
    }

    @Override
    public final int initializeFromMap(HashMap<String, Object> serial) throws IOException {
        int hash = 0;
        ObjectHashPair<String> ohp = model.utils.SerialUtils.getObjectFromMap(serial, "displayName", "");
        displayName = ohp.obj;
        hash += 17 * ohp.hash;
        return hash;
    }

}