DetachedCriteria detachedCriteria = DetachedCriteria.forClass(ForumQuestion.class);
Disjunction disjunction = Restrictions.disjunction();
for (String searchUnitString : searchSet) {
     disjunction.add(Restrictions.ilike("forumQuestion", "%"+searchUnitString+"%"));
}
detachedCriteria.add(disjunction);
return template.findByCriteria(detachedCriteria);