private Set<Subscriber<?>> getSubscriberSet(Class<?> clazz) {
    Set<Subscriber<?>> subs = subscribersByClass.get(news.getClass());
    if (subs == null) {
        subs = new HashSet<Subscriber<?>>();
        subscribersByClass.put(subs);
    }
    return subs;
}