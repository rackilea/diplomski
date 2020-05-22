int andClauses= 0; // number of clauses that should be connected with "and" operation

QueryBuilder<Client, Integer> builder = clientsDao.queryBuilder();
Where<Client, Integer> builderWhere = builder.where();

if (!TextUtils.isEmpty(tfSearchName.getText())) {
    builderWhere.like("name", tfSearchName.getText().trim());
    andClauses++;
}

if (!TextUtils.isEmpty(tfSearchBalanceMin.getText())) {
    builderWhere.gt("balance", tfSearchBalanceMin);
    andClauses++;
}

if (!TextUtils.isEmpty(tfSearchBalanceMax.getText())) {
    builderWhere.lt("balance", tfSearchBalanceMax);
    andClauses++;
}

clientTable.setItems(FXCollections.observableArrayList(
            andClauses > 0 ? clientsDao.query(builderWhere.and(andClauses).prepare())
                    : clientsDao.queryForAll()));