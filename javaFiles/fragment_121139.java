List<MonthDay> uniqueDates = new ArrayList<MonthDay>();
for (MonthDay md : dates) {
    if(myMap.get(md.getMonth()) == 1){
        uniqueDates.add(md);
    }
}

return uniqueDates;