public int differenceInYears(MyDate comparedDate) {
    int difference;

    if (this.year > comparedDate.year) {
        difference = this.year - comparedDate.year;

        if (this.month > comparedDate.month) {
        }
        else if (this.month == comparedDate.month) {
            if (this.day >= comparedDate.day) {
            }
            else {
                difference -= 1;
            }
        }
        else {
            difference -= 1;
        }
    }
    if (comparedDate.year > this.year) {
        difference = comparedDate.year - this.year;

        if (comparedDate.month > this.month) {
        }
        else if (comparedDate.month == this.month) {
            if (comparedDate.day >= this.day) {
            }
            else {
                difference -= 1;
            }
        }
        else {
            difference -= 1;
        }
    }

    return difference;
}