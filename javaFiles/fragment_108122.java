@Override
public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
    long start = System.nanoTime();

    if(super.tryLock(time, unit)){

        time -= unit.convert(System.nanoTime() - start, TimeUnit.NANOSECONDS);

        if(next.tryLock(time, unit))
            return true;
        else
            super.unlock();
    }
    return false;
}