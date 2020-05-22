@SuppressWarnings("rawtypes")
List<BigDecimal> queryList = executeReadAllSQLQuery(queryString);

FDetails details = new FDetails();
int i = 0;
details.setPb(queryList.get(i ++));
details.setPm(queryList.get(i ++));
...

fDList.add(pDetails);