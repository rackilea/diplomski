public static void main(String[] args) {
    int count, sum = 0;           
    for (int i = 1901; i < 2001; i++) { // There is a mistake here, I dont know what you want to compute in this loop!
        LocalDate test = LocalDate.of(i,1,1);
        sum += test.lengthOfYear();
    }
    for (int i = 1; i < sum; i++) {
        LocalDate date1 = LocalDate.of(1901,1,1); // There is a mistake here, date1 must be outside of this loop
        date1 = date1.plusDays(i); // There is a mistake here, plusDays why?? 
    if(date1.getMonth() == JANUARY && date1.getDayOfWeek() == SUNDAY) { // There is a mistake here, why are you cheking this: date1.getMonth() == JANUARY ?
        count++;
        }
    }
    System.out.println(count);
}