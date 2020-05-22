for(int i = 0; i < arrDocumentNumber.length; i++){

params.add(new BasicNameValuePair(TAG_DOCUMENTNUMBER, arrDocumentNumber[i] ));
params.add(new BasicNameValuePair(TAG_TRANSACTIONDATE, arrTransactionDate[i] ));
params.add(new BasicNameValuePair(TAG_ITEMCODE, arrItemCode[i] )); 

}