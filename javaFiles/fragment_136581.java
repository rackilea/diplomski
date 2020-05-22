public CompletionStage<Result> editAccount() {
    Map<String, String[]> form_values = request().body().asFormUrlEncoded();
    return accountDao.getUserByEmail(session().get("accountEmail")).thenApply(account -> {
        System.out.println("Async get Account / "+Thread.currentThread());
        account.setCompany(form_values.get("company")[0]);
        return accountDao.updateAccount(account);
    }).thenApplyAsync(account -> {
        System.out.println("Async resutl / "+Thread.currentThread());
        return ok("Account saved normal");
    }, httpExecutionContext.current()).exceptionally(e ->{
        System.out.println("Async exception / "+Thread.currentThread());
        System.out.println(e.getLocalizedMessage());
        return ok(e.getLocalizedMessage());
    });
}