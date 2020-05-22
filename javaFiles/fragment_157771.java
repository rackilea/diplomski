Calendar end = Calendar.getInstance();
end.set(MONTH, month);  // next month 
end.set(YEAR, year);
end.set(DAY_OF_MONTH, 1);
end.getTime();   // to avoid problems getTime make set changes apply
end.set(DATE, -1);
end.set(DAY_OF_WEEK, SATURDAY);
if (end.get(MONTH) != month)  
    end.add(DATE, + 7);