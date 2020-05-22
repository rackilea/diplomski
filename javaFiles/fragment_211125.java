if (date1.year == date2.year){
    if (date1.month == date2.month){
        return date1.day > date2.day;
    }
    else
        return date1.month > date2.month;
}
else
    return date1.year > date2.year;