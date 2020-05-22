public boolean isEarlier(Date other) {
    if (getYear() < other.getYear()) {
        return true;
    } else if (getYear() > other.getYear()) {
        return false;
    }

    // If we reached here, both dates' years are equal

    if (getMonth() < other.getMonth()) {
        return true;
    } else if (getMonth() > other.getMonth()) {
        return false;
    }

    // If we reached here, both dates' years and months are equal

    return getDay() < other.getDay();
}