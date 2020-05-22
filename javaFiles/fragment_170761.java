Map<String, Object> closedTaxLotByTxnId =
           data.values()
               .stream()
               .filter(m -> m.get(Constants.USER_TRAN_ID).equals(stsTxn.getSeedTrade().getTransactionId()))
               .findFirst()
               .orElse(null);