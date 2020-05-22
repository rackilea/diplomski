protected void makeAccountDefault (BankAccount acc) {

    // find & clear any existing 'Default Accounts', other than specified.
    //
    String sql = "SELECT * FROM BANKACCOUNTS WHERE PARTYID = :partyId AND CURRENCYID = :currencySymbol AND ISDEFAULTBANKACCOUNT= :defaultbankAccount";
    SQLQuery q = session.createSQLQuery(sql);
    q.addEntity(BankAccount.class);
    q.setParameter("partyId", partyId);
    q.setParameter("currencySymbol", currencySymbol);
    q.setParameter("defaultbankAccount", 1);
    //
    List<BackAccount> existingDefaults = q.list();
    for (BankAccount existing : existingDefaults) {
        if (! existing.equals( acc))
            existing.setDefaultBankAccount( false);
    }

    // set the specified Account as Default.
    acc.setDefaultBankAccount( true);

    // done.
}