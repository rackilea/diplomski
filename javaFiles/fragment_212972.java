try {
    throw new RuntimeException("foobar");
} catch (RuntimeException e) {
    Runnable r = () -> { System.out.println(e); };
    r.run();
}