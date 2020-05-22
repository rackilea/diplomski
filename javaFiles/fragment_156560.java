public File savedHashMaps = new File("SavedHashMaps.list");
public Map<Location, Long> map = new HashMap<Location, Long>();

public void saveMaps() {
    try {
        ObjectOutputStream oos = new ObjectOutputStream (new FileOutputStream(savedHashMaps));
        oos.writeObject(map);
        oos.close();
    } catch (Exception e) {
        // Catch exceptions
    }
}

public void loadMaps() {
    try {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(savedHashMaps));
        Object readMap = ois.readObject();
        if(readMap != null && readMap instanceof HashMap) {
            map.putAll((HashMap) readMap);
        }
        ois.close();
    } catch (Exception e) {
        // Catch exceptions
    }
}