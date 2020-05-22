protected boolean validateResources(boolean useClassLoaderResources) {
        long now = System.currentTimeMillis();
        if (this.webResources == null) {
            ...
        }

        // TTL check here!!
        if (now < this.nextCheck) {
            return true;
        } else if (this.root.isPackedWarFile()) {
            this.nextCheck = this.ttl + now;
            return true;
        } else {
            return false;
        }
    }