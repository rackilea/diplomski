List<Investor> list;
for(Investor investor : registerdUsers) {
     formatedDate = sdf.format(investor.getRegistrationDate());
     if (dateWiseInvestorsMap.containsKey(formatedDate)) {
         list = dateWiseInvestorsMap.get(formattedDate);
     } else {
         list = new ArrayList<Investor>();
         dateWiseInvestorsMap.put(formatedDate, list);
     }
     list.add(investor);
 }