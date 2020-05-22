for (;;) {
        int current = get();
        int next = current - 1;
        if (compareAndSet(current, next))
            return next;
    }