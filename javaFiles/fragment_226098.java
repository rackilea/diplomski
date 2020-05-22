public LiveData<BigDecimal> calculateMonthlyCosts(SubViewModel subViewModel) {
    MediatorLiveData<BigDecimal> mediator = new MediatorLiveData<>() {
        private BigDecimal cMonthly = new BigDecimal(0);
        private BigDecimal cBiannually = new BigDecimal(0);
        private BigDecimal cYearly = new BigDecimal(0);

        {
            addSource(subViewModel.getAllMonthlyCosts(), new Observer<BigDecimal>() {
                @Override
                public void onChanged(@Nullable BigDecimal bigDecimal) {
                    if (bigDecimal != null) {
                        cMonthly = cMonthly.add(bigDecimal);
                        setValue(cMonthly);
                    }
                }
            });

            addSource(subViewModel.getAllBiannuallyCosts(), new Observer<BigDecimal>() {
                @Override
                public void onChanged(@Nullable BigDecimal bigDecimal) {
                    if (bigDecimal != null) {
                        cBiannually = cBiannually.add(bigDecimal.divide(new BigDecimal(6), 2));
                        setValue(cMonthly); // TODO: ???
                    }
                }
            });

            addSource(subViewModel.getAllYearlyCosts(), new Observer<BigDecimal>() {
                @Override
                public void onChanged(@Nullable BigDecimal bigDecimal) {
                    if (bigDecimal != null) {
                        cYearly = cYearly.add(bigDecimal.divide(new BigDecimal(12), 2));
                        cMonthly = cMonthly.add(cBiannually).add(cYearly);
                        setValue(cMonthly);
                    }
                }
            });
         }
    };

    return mediator;
}