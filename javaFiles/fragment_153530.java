// within the class of "filter"
    Predicate<LocationVO> createLocationVOPredicate() {
        Predicate<LocationVO> p = l -> true;
        if (getClient_id() != null) {
            p = p.and(l -> getClient_id().longValue() ==  l.getParent_client_id());
        }
        if (getLocation_id() != null) {
            p = p.and(l -> l.getLocation_id().longValue() == getLocation_id());
        }
        if (getLocation_type() != null) {
            p = p.and(l -> getLocation_type().equals(l.getLocation_type()));
        }
        return p;
    }