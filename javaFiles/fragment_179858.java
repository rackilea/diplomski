if (compareTo(ba) < 0) {
        former = this;
        latter = ba;
    } else {
        former = ba;
        latter = this;
    }
    synchronized (former) {
        synchronized (latter) {
            //Some logic
        }
    }
}