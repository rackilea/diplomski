public Date dateTime(Date date, Date time) {
    return new Date(
                     date.getYear(), date.getMonth(), date.getDay(), 
                     time.getHours(), time.getMinutes(), time.getSeconds()
                   );
}