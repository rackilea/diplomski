Thread t = new Thread(new Runnable() {
        @Override
        public void run() {
            Acao a = new Acao();
            a.predio();
            a.casa();
            a.carro();
        }
    });
t.start();