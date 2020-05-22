List<Object[]> listObject = rep.findPaymentValuePerDay();
for(Object[] obj : listObject){
   Date date = (Date) obj[0];
   Long value1 = (Long) obj[1];
   Long value2 = (Long) obj[2];
}