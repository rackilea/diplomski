try (QueryCursor<Cache.Entry<Integer, Person>> cur = cache.query(qry)) {
    // Iterate through existing data.
    for (Cache.Entry<Integer, Person> e : cur)
        System.out.println("Queried existing entry [key=" + e.getKey() + ", val=" + e.getValue() + ']');
    Thread.sleep(2000);
}