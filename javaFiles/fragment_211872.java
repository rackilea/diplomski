public boolean isEarlier(Date other) {
    return Comparator.comparingInt(Date::getYear)
                     .thenComparingInt(Date::getMoth)
                     .thenComparingInt(Date::getDay)
                     .compare(this, other) < 0;
}