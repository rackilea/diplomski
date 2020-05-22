public int compareTo(Date date) {
    if(getYear() == date.getYear()) {
        if (getMonth() == date.getMonth()) {
            return getDay() - date.getDay ();
        } else {
            return getMonth() - date.getMonth ();
        }
    } else {
        return getYear() - date.getYear();
    }
}