public Editor putStringSet(String key, Set<String> values) {
        synchronized (this) {
            mModified.put(key,
                    (values == null) ? null : new HashSet<String>(values));
            return this;
        }
    }