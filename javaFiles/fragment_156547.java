private final MyDataStructure<Key, Integer> datastructure = new CustomDataStructure<Key, Integer>();

private class MyThread implements Runnable() {

    private void incrementCnt(Key key) {
        synchronized (datastructure) {
            // or can I do it without using the getCnt() function? like this:
            datastructure.put(key, datastructure.get(key)+1));
        }
    }