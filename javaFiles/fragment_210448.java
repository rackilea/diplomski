if (size.incrementAndGet() < max) {
            return queue.offer(t);
        } else {
            // Undo my excessive increment.
            size.decrementAndGet();
        }