DateTime one = new DateTime(original-Date-1);
DateTime two = new DateTime(original-Date-2);

LocalDate oneDate = one.toLocalDate();
LocalDate twoDate = two.toLocalDate();

return oneDate.compareTo(twoDate);