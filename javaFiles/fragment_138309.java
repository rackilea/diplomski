Criteria criteria = getSession().createCriteria(getEntity(), "b"); 
Criterion isTwitterVerified = Restrictions.eq("b.isTwitterVerified", 1);
Criterion isFbVerified = Restrictions.eq("b.isFbVerified ", 1);
criteria.add(Restrictions.or(isTwitterVerified , isFbVerified ));

return criteria.list();