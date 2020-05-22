if (found != null) {
    Account ac = new Account(
        (String) found.get("_id"),
        (String) found.get("trimuuid"),
        ... ,
        (List) found.get("Multipliers"),
        ...
    );
    ac.newAccount();
}