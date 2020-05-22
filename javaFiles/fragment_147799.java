Criteria crit = io.getSession().createCriteria(Company.class);
 List<Company> list = 
       crit.createAlias("users", "u")
       .createAlias("u.usertypes", "ut", Criteria.INNER_JOIN, 
                         Restrictions.eq("ut.typeofuser", "Stooge")
       .list();