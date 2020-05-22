public class BossExample {
  // Key: Boss-ID, Value: Boss name
  private Map<Integer, String> mapOfBosses = new HashMap<Integer, String>();

  // Key: Emp name, Value: Boss-ID
  private Map<String, Integer> mapOfEmps = new HashMap<String, Integer>();

  // Constructor fills the maps
  public BossExample() {
    // ...
  }

  // Returns a mapping from Emp name to Boss name
  public Map<String, String> getEmpToBossMap() {
    final Map<String, String> empToBossMap = new HashMap<String, String>();

    // Iterate through mapOfEmps via entrySet giving you key and value 
    // at the same time
    for(Map.Entry<String, Integer> empEntry : mapOfEmps.entrySet()) {
      // Put the Emp name as key and the retrieved Boss name as a value into 
      // the result map.
      empToBossMap.put(empEntry.getKey(), mapOfBosses.get(empEntry.getValue()));
    }

    return empToBossMap;
  }
}