if (prefix == null || prefix.length() == 0) {
        synchronized (mLock) {
            ArrayList<T> list = new ArrayList<T>(mOriginalValues);
            results.values = list;
            results.count = list.size();
        }
    }