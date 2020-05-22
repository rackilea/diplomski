PaymentDetail APD1 = PaymentDetail.as("APD1");
PaymentDetail APD2 = PaymentDetail.as("APD2");
Payment AP = Payment.as("AP");

DSL.using(configuration)
   .select(count(1).as("CountPayments"))
   .from(APD1, APD2, AP)
   .where(APD1.PaymentNumber.eq(123))
   .and(APD1.BillNumber.gt(0))
   .and(APD2.BillNumber.eq(APD1.BillNumber))
   .and(APD2.PaymentNumber.ne(APD1.PaymentNumber))
   .and(AP.PaymentNumber.eq(APD2.PaymentNumber))