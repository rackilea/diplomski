@Override
public Bank balance(String account_name) {
  Query query = entityManager.createNativeQuery("select * from <TABLE_NAME> where <COLUMN_NAME> = ?", Bank.class);

  query.setParameter(1, account_name);
  query.setMaxResults(1);

  return (Bank)query.getSingleResult();
}