int years = 0;

    double endValue = investment;

    while (endValue < futureValue) {
        years++;
        endValue = investment * Math.pow((1 + rate), years);
    }