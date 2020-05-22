void iterate() {
    final Thread t = new Thread(new Runnable() {
        @Override
        public void run() {
            while (porcentaje < 2000) {
                pgbCargando.setValue(porcentaje);
                try {
                    Thread.sleep(100);
                } catch (final InterruptedException e) {
                }
                porcentaje += 95;
            }
        }
    });
    t.setDaemon(true);
    t.start();
}