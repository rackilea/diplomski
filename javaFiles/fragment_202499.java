Map<String, List<Fee>> feeAccountMap = ContractList
            .stream()
            .filter(o -> !o.getStatus().equals(ContractStatus.CLOSED))
            .collect(Collectors.toMap(o -> o.getFeeAccount(), o -> {
                List<Fee> monthlyFees;
                try {
                    monthlyFees = contractFeeService.getContractMonthlyFees(o);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                return monthlyFees;
            }, (value1, value2) -> value1
            ));