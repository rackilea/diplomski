List<Integer> idsWithoutMandates = new ArrayList<>();
        List<SqlRow> rowList = Ebean.createSqlQuery("SELECT debits.id id " +
                "FROM bank_debit AS debits " +
                "LEFT JOIN bank_debit_mandate AS jointable ON (debits.id = jointable.bank_debit_id) " +
                "WHERE (jointable.mandate_id IS NULL OR jointable.mandate_id = 0)").findList();

for (SqlRow sqlRow : rowList) idsWithoutMandates.add(sqlRow.getInteger("id"));

List<BankDebit> debitsWithoutMandates = BankDebit.find.where().in("id", idsWithoutMandates).findList();