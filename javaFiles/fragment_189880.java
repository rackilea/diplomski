String hql = "from POJO as POJO where POJO.tradeDate between :date and :ceilDate"; 
Query query = getSession().createQuery(hql); 
// a date having timestamp part, 00:00:00.0, or missing completely
query.setParameter("date", date); 
// a date having timestamp part, 23:59:59.999
query.setParameter("ceilDate", ceilDate);