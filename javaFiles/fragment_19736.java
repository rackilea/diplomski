static final AtomicBoolean isTokenSync = new AtomicBoolean(false);
private static final Phaser phaser = new Phaser(1);

int phase = phaser.getPhase();
if (isTokenSync.compareAndSet(false, true)) {  

        generateAndSaveToken(...);

        phaser.arrive();
        isTokenSync.set(false);   
    }
    else {
        try {
            phaser.awaitAdvance(phase);
        } catch (InterruptedException e) {
        }
    }
}