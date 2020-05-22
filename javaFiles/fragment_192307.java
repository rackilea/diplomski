MainframeDatabaseAccessor mock = mock(MainFrameDatabaseAccessor.class);
when(mock.findAccount(id1)).thenReturn(sourceAccount);
when(mock.findAccount(id2)).thenReturn(destinationAccount);

BankingService service = new BankingService(mock);
service.transfer(id1, id2, 1000);
// now test that sourceAccount has lost 1000 dollars and destinationAccount has won 1000 dollars

verify(mock).logTransaction(any(Transaction.class));