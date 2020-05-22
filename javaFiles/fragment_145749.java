synchronized (this) {
            while (this.atomosH_esperando == 2 || (this.atomosHidrogeno < 1 && this.atomosOxigeno < 0)) {
                try {
                    wait();
                    this.atomosH_esperando++;
                } catch (InterruptedException ie) {
                }
            }
            notifyAll();
        }
        this.atomosH_esperando--;