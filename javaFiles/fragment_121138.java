for (MonthDay md : dates){
    Month currentMonth = md.getMonth();
    if(myMap.containsKey(currentMonth)){
        myMap.put(currentMonth, myMap.get(currentMonth) + 1);
    }
    else{
        myMap.put(currentMonth, 1);
    }
}