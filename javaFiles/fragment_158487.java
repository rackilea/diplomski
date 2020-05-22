for (int i = 0; i < 5; i++) {
    ThreadContext.clearAll();
    ThreadContext.put("delay", String.valueOf(i));
    ThreadContext.put("name", "Ash " + i);
    LOGGER.info("Testing ", "k1", "v1", "k2", "v2");
}