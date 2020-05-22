while (keys.hasNext()) {
    try {
        String key = (String) keys.next();
        Object value = jObject.get(key);
        log.debug("value--" + map);
        map.put(key, value);
    } catch (Exception e) {
        log.trace("getUserBG--", e);
    }
}