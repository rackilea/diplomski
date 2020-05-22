private final Semaphore permit = new Semaphore(8, true);
private final Random random = new Random();

private boolean canFoo() {
    return random.nextBoolean();
}

private void doFoo() {
    System.out.println("Foo done!");
}

private void reticulateSpines() {
    System.out.println("Spines reticulated!");
}

public void m() throws InterruptedException {
    permit.acquire();
    try {
        while (!canFoo()) {
            permit.release();
            try {
                reticulateSpines ();
            } finally {
                permit.acquire();
            }
        }
        doFoo();
    } finally {
        permit.release();
    }
}