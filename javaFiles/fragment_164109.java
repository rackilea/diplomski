String getAndClear(String key) {
    String[] result = {null};    
    cache.asMap().compute(key, (k, v) ->
        result[0] = v;
        return null;
    });
    return result[0];
}