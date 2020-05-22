public int differenceInYears(MyDate comparedDate) {
    MyDate a = (this.year < comparedDate.year) ? this : comparedDate;
    MyDate b = (this.year < comparedDate.year) ? comparedDate : this;

    int difference = b.year - a.year;

    if (a.year < b.year) {
        if (a.month == b.month && a.day < b.day ||
            a.month < b.month)
        {
            difference -= 1;
        }
    }

    return difference;
}