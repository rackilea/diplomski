Date fromDate = form.getFromDate();
Date toDate = form.getToDate();
LocalDateTime from = LocalDateTime.ofInstant(fromDate.toInstant(), ZoneId.systemDefault());
LocalDateTime to= LocalDateTime.ofInstant(toDate.toInstant(), ZoneId.systemDefault());

if(Duration.between(from, to).toDays() <= 30){
//do work
}