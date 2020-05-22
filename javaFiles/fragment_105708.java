public class PetersonLockUnlock implements MutexInterface {
    private AtomicInteger[] levels;
    private AtomicInteger[] lastToEnter;
    private int n;

    public PetersonLockUnlock(int n) {
        this.n = n;

        this.levels = new AtomicInteger[n];
        this.lastToEnter = new AtomicInteger[n];

        for (int i = 0; i < n; i++) {
            this.levels[i] = new AtomicInteger(-1);
            this.lastToEnter[i] = new AtomicInteger(-1);
        }
    }

    public void lock(int i) {
        for (int l = 0; l < this.n - 1; l++) {
            this.levels[i].set(l);
            this.lastToEnter[l].set(i);
            while (this.lastToEnter[l].get() == i && existsLevelGteL(l, i)) {
                // busy-wait
            }
        }
    }

    private boolean existsLevelGteL(int l, int i) {
        for (int k = 0; k < this.n; k++) {
            if (k != i && this.levels[k].get() >= l) {
                return true;
            }
        }
        return false;
    }

    public void unlock(int i) {
        this.levels[i].set(-1);
    }
}