private Observable<List<Result<Account, IError>>> filterAccounts(Context context, List<Account> accounts) {
        return accountDAL
                .getByIds(context,
                        accounts.stream().map(a -> Long.valueOf(a.getAccountId())).collect(Collectors.toList()))
                .map(ar -> ar.stream().collect(Collectors.toMap(Account::getAccountId, Function.identity())) // map ==>
                                                                                                            // {id =
                // Account}

                ).flatMap(seMap -> accountDAL.save(context, accounts.stream()
                        .filter(a -> seMap.get(Long.valueOf(a.getAccountId())) == null).collect(Collectors.toList())));
    }