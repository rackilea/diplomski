Predicate<LocationVO> p = l -> true;
    if (filter.getClient_id() != null) {
        p = p.and(l -> filter.getClient_id().longValue() !=  l.getParent_client_id());
    }
    if (filter.getLocation_id() != null) {
        p = p.and(l -> l.getLocation_id().longValue() == filter.getLocation_id());
    }
    if (filter.getLocation_type() != null) {
        p = p.and(l -> filter.getLocation_type().equals(l.getLocation_type()));
    }