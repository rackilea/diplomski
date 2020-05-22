Query q = new Query("AllowedUser");
q.setFilter(new FilterPredicate("JID", Query.FilterOperator.EQUAL, "[[ user JID to check ]]");
PreparedQuery pq = datastore.prepare(q);
if (pq.countEntities(FetchOptions.Builder.withLimit(1)) > 0) {
    // user is allowed
} else {
    // user is not allowed
}