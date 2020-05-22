PipedOutputStream pos = new PipedOutputStream();
InputStream is = new PipedInputStream(pos);

new Thread(() -> {
    try (ObjectOutputStream oos = new ObjectOutputStream(pos)) {
        Iterator<MyType> myItr = MyObject.getStream().iterator();
        while (myItr.hasNext()) {
            oos.writeObject(myItr.next().toString()
                .getBytes(StandardCharsets.UTF_8));
        }
    } catch (IOException e) {
        // handle closed pipe etc.
    }
}).start();