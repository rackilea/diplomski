@Override
public void run() {
    int i = 0;
    while (i < 100) {
        synchronized (stored_integer) {
            System.out.format("%s: Writing %d to StoredInteger\n", this.getClass().getSimpleName(), i);
            stored_integer.value = i;
            i++;
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            //
        }
    }
}

@Override
public void run() {
    int i = 0;
    while (i < 100) {
        synchronized (stored_integer) {
            System.out.format("%s: Reading %d from StoredInteger\n", this.getClass().getSimpleName(), stored_integer.value);
            i++;
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
        }
    }
}