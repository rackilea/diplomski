@PostMapping(name="put")
public void putData(String key, Metric metricData) {
    metricStore.store.compute(key, (k, v) -> {
        if (v == null) {
            return metricData;
        }

        // update data
    });
}

@PostMapping(name="remove")
public void removeData(String key) {
    metricStore.store.computeIfPresent(key, (k, v) -> null);
}