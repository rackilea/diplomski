BigDecimal totalbalance = null;
String theQuery = "select sum(dt.beforeBalance) from DepositTransaction dt";
Query query = session.createQuery(theQuery);
totalbalance = (BigDecimal) query.getSingleResult();

return totalbalance;