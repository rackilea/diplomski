// or use a callback to work with kryo - no need to borrow/release,
// that's done by `run`.
String value = pool.run(new KryoCallback() {
  public String execute(Kryo kryo) {
    return kryo.readObject(input, String.class);
  }
});