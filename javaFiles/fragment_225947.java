int currentBranchCode = 0;
        for (Integer CCS : companyArrayList) {
            if (currentBranchCode <= CCS) {
                currentBranchCode = CCS;
            }
        }