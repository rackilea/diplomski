public void run() {
    final AtomicReference<Looper> wrapper = new AtomicReference<Looper>();
    Looper looper = new Looper(new Commandable() {
        @Override
        public void execute() {
            System.out.println("This is easy: ");
            System.out.println("This isn't easy: " + wrapper.get().getI());
        }
    });
    wrapper.set(looper);
    looper.execute();
}