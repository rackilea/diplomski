public double grossPay() {
    double baseRate = wage_rate * hours;
    double timeAndAHalf = baseRate + (wage_rate * 1.5) * (hours - 40);
    double doubleTime = timeAndAHalf + (wage_rate * 2) * (hours - 60);
    if (hours <= 40) {
        return baseRate;
    } else if (hours > 40 && hours <= 60) {
        return timeAndAHalf;
    } else {
       return doubleTime;
    }
    return grosspay;
}