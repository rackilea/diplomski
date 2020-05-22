public int differenceInYears(MyDate comparedDate) {
    int difference;

    if (this.year > comparedDate.year) {
        difference = this.year - comparedDate.year;

        if (this.month == comparedDate.month && this.day < comparedDate.day ||
            this.month < comparedDate.month)
        {
            difference -= 1;
        }
    }
    if (comparedDate.year > this.year) {
        difference = comparedDate.year - this.year;

        if (comparedDate.month == this.month && comparedDate.day < this.day ||
            comparedDate.month < this.month)
        {
            difference -= 1;
        }
    }

    return difference;
}