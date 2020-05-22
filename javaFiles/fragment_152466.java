List<FeeRequest> feeRequests =
    feeAccounts.entrySet()
               .stream()
               .flatMap(feeAcc -> feeAcc.getValue()
                                        .stream()
                                        .map(f -> {
                                            FeeRequest request = new FeeRequest();
                                            request.setDebtorAccount(feeAcc.getKey());
                                            request.setFeeCode(f.getCode());
                                            return request;
                                        }))
               .collect(Collectors.toList());