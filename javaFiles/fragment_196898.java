SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
Criteria criteria = Criteria.forClass(DriverEntity.class,"driver");
DetachedCriteria dc = DetachedCriteria.forClass(LicenceEntity.class,"licence");
dc.add(Property.forName("driver.id").eqProperty("licence.driverId"));
dc.add(Restrictions.between("validFrom", df.parse("2014-01-01"), df.parse("2014-04-17")));
dc.add(Restrictions.between("validTo", df.parse("2014-07-02"), df.parse("2095-07-12")));

criteria.add(Subqueries.exists(dc.setProjection(Projections.id())));