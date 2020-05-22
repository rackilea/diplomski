interface Config { String getSomeProperty(); }

class ConcreteConfig implements Config{
    public String getSomeProperty() {
        return "some value";
    }
}

class ConfigWrapper implements Config {
    private Config backing;
    private ReadWriteLock lock = new ReentrantReadWriteLock();

    public void setBacking(ConfigBacking backing) {
        try {
            lock.writeLock().lock();
            this.backing = backing;
        } finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public String getSomeProperty() {
        try {
            lock.readLock().lock();
            return backing.getSomeProperty();
        } finally {
            lock.readLock().unlock();
        }
    }
}