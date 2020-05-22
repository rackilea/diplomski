Single<BigDecimal> summarizeConfirmedTransactions() throws SummarizationException {


            Observable<Transaction> observableTransactions = transactions.get();
            Observable<Confirmation> observableConfirmations = confirmations.get();
            return Observable.zip(observableTransactions, observableConfirmations,
                    (t, c) -> new ConfirmableTransaction(c.isConfirmed, t.value))
                    .filter(confirmableTransaction -> confirmableTransaction.isConfirmed)
                    .map(t -> t.value)
                    .reduce(BigDecimal::add)
                    .toSingle()
                    .onErrorResumeNext(th -> Single.error(new SummarizationException(th.getMessage())));
    }