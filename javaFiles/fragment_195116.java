ConcurrentHashMap<String, Boolean> map = new ConcurrentHashMap<>();

public void writeToFile(String fileName, byte[] data) {
    // putIfAbsent returns the value previously associated with fileName, or null
    if(map.putIfAbsent(fileName, Boolean.TRUE) == null) {
        try(FileOutputStream stream = new FileOutputStream(fileName)){
            stream.write(data);
        } finally {
            map.remove(filename);
        }
    }
}