public MyDate nextMonth(){
    if (month<12){
        month++;
        setDay(1);
        return this;               //return current object
    }
    else
        nextYear();
    return this;               //return current object
}