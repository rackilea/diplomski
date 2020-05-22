dc.add(
  Restrictions.sqlRestriction(
    "substring_index({alias}.value,',',-1) between ? and ?",
     new Object[]{startDate,endDate},
     new Type[]{StandardBasicTypes.DATE,StandardBasicTypes.DATE}
  )
);