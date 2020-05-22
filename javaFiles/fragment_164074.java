public LiveData<Long> getRemainingIncome() {
    MediatorLiveData<Long> remainingIncome = new MediatorLiveData<>();
    LiveData<SumOfRowsFromDB> income = mainDashBoardDao.getTansWiseSum(Constants.TRANS_TYPES.get(2));
    LiveData<SumOfRowsFromDB> expense = mainDashBoardDao.getTansWiseSum(Constants.TRANS_TYPES.get(1));
    remainingIncome.addSource(income, value -> {
        remainingIncome.setValue(combinedResult(income, expense));
    });
    remainingIncome.addSource(expense, value -> {
        remainingIncome.setValue(combinedResult(income, expense));
    });
    return remainingIncome;
}

private Long combinedResult(LiveData<SumOfRowsFromDB> income, LiveData<SumOfRowsFromDB> expense) {
    if (income.getValue() != null && expense.getValue() != null) {
        return (income.getValue().getSumOfRow() - expense.getValue().getSumOfRow());
    } else {
        return 0L;
    }