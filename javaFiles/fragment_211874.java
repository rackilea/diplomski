public boolean isEarlier(Date other) {
    return (getYear() < other.getYear()) ||
           (getYear() == other.getYear() && 
            getMonth() < other.getMonth()) ||
           (getYear() == other.getYear() && 
            getMonth() == other.getMonth() && 
            getDay() < other.getDay());
}