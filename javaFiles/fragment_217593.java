@Override
public List<Bank> balance(String account_name) {
  Query query = entityManager.createNativeQuery("select * from <TABLE_NAME> where <COLUMN_NAME> = ?", Bank.class);
  query.setParameter(1, account_name); // here we set value for param (it's "?" in the SQL)
  query.setMaxResults(1); // this is used to limit the result list

  // you should probably remove this
  /* if (query.getResultList().size() == 1 ) {
    return query.getResultList();
  }*/

  return query.getResultList();
}