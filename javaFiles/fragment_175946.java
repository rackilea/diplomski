DetachedCriteria criteria = DetachedCriteria.forClass(Log.class);
criteria.createAlias("employee", "e");

if (StringUtils.isNotBlank(c.getName())) {
    criteria.add(Restrictions.ilike("e.name", c.getName(), MatchMode.ANYWHERE));
}

if (StringUtils.isNotBlank(c.getAgency())) {
    criteria.createAlias("e.agency", "a"); //  <===========
    criteria.add(Restrictions.ilike("a.name", c.getAgency(), MatchMode.ANYWHERE));
}