Map<String, Runnable> hmap = new HashMap<>();
// code to fill map here

for (Map.Entry<String, Runnable> pair : hmap.entrySet()){
    if (pair.getKey().equals(extractClassNameFromComand)) {
        pair.getValue().run();
    }
}