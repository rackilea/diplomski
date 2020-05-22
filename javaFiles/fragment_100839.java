public int differenceInYears(MyDate comparedDate) {
    int difference;

    if (this.year > comparedDate.year) {
        difference = this.year - comparedDate.year;

        if (this.month == comparedDate.month) {
            if (this.day < comparedDate.day) {
                difference -= 1;
            }
        }
        else if (this.month < comparedDate.month) {
            difference -= 1;
        }
    }
    if (comparedDate.year > this.year) {
        difference = comparedDate.year - this.year;

        if (comparedDate.month == this.month) {
            if (comparedDate.day < this.day) {
                difference -= 1;
            }
        }
        else if (comparedDate.month < this.month) {
            difference -= 1;
        }
    }

    return difference;
}