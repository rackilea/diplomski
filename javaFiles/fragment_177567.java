@Override
public void run() {
    int i = 0;
    while (i < 100) {
        synchronized (stored_integer) {
            System.out.format("%s: Writing %d to StoredInteger\n", this.getClass().getSimpleName(), i);
            stored_integer.value = i;
            i++;

            // Writer wakes up writer
            stored_integer.notify();

            // Writer waits until it can read
            try {
                stored_integer.wait();
            } catch (InterruptedException ex) {
                //
            }
        }
    }
}

@Override
public void run() {
    synchronized (stored_integer) {
        // Reader waits for the first time!
        try {
            stored_integer.wait();
        } catch (InterruptedException ex) {
            //
        }
    }
    int i = 0;
    while (i < 100) {
        synchronized (stored_integer) {

            System.out.format("%s: Reading %d from StoredInteger\n", this.getClass().getSimpleName(), stored_integer.value);
            i++;

            // Reader wakes up writer
            stored_integer.notify();

            // If there are still more values to read
            if (i < 100) {
                // Reader waits until it can read
                try {
                    stored_integer.wait();
                } catch (InterruptedException ex) {
                    //
                }
            }
        }
    }
}