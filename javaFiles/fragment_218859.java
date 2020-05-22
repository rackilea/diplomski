public Events findById( java.lang.Integer id) {
        log.debug("getting Events instance with id: " + id);
        try {
            Events instance = (Events) getSession()
                    .get("com.hibernate.Events", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }