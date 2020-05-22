for(License license: licenses) {
        em.persist(license);
    }
    Driver driver = new Driver();
    driver.getLicenses().add(licenses);
    em.persist(driver);
    // merge circular dependency
    for(License license: licenses) {
        license.setDriver(driver);
        em.merge(license);
    }