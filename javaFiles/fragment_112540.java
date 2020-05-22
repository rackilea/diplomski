public synchronized void HandleItems() {
        if (!items.isEmpty()) {
            for (Item i : items) {
                i.Update();
            }
        }
    }