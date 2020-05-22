try {
    throw new RuntimeException("foo");
} catch (RuntimeException e) {
    e = new RuntimeException("bar", e);
    Runnable r = () -> { System.out.println(e); }; // ERRROR
    r.run();
}