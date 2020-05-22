private Observable<List<Result<Account, IError>>> filterAccounts(Context context, List<Account> accounts){
     return accountDAL.getByIds(context, accounts
            .stream()
            .map(a -> Long.valueOf(a.getAccountId()))
            .collect(Collectors.toList()))
            .map(a -> 
                 a.stream()
                        .collect(Collectors.toMap(a -> a.getId(), Function.identity())) // map ==> {id = Account}

            ).map(seMap -> 
               accountDAL.save(context, accounts.stream()
                     .filter(a -> seMap.get(Long.valueOf(a.getAccountId())) == null)
                     .collect(Collectors.toList())).first());
}