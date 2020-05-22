public init(String[] credentials) {
    Account account = null;     
    String uniqueID = uniqueAccountIdentifier(credentials);

    synchronized (SHARED_ACCOUNT_HASHMAP) {
        if (SHARED_ACCOUNT_HASHMAP.containsKey(uniqueID)) {
            account = SHARED_ACCOUNT_HASHMAP.get(uniqueID);
            log("...retrieved Shared Account object: %s", uniqueID);
        }

        // create the Account object (if necessary)
        if (account == null) {
            account = new Account(credentials);

            // Store it in the SHARED_ACCOUNT_HASHMAP
            SHARED_ACCOUNT_HASHMAP.put(uniqueID, account);
            log("...created Account object: %s",uniqueID);
        }
    }
}