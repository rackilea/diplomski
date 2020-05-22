DetachedCriteria dc = DetachedCriteria.forClass(Config.class); 
dc.add(Restrictions.eq("loginname",loginname));

dc.add(
  Restrictions.sqlRestriction(
    "substring_index(substring_index({alias}.value,',',-1),',',2) between ? and ?",
     new Object[]{startDate,endDate},
     new Type[]{StandardBasicTypes.DATE,StandardBasicTypes.DATE}
  )
);