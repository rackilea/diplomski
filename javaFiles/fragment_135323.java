while (bookVal > salvageVal){   // also change
    yearlyDepr = bookVal * (ddRate / 100);
    accDepr = accDepr + yearlyDepr;
    bookVal = bookVal - yearlyDepr;
    year++;

    if (bookVal < salvageVal) {
        bookVal = salvageVal;
        yearlyDepr = purchPrice - salvageVal;
    }

    System.out.printf("%d %,18.0f %,18.0f %,18.0f%n" , year, yearlyDepr, accDepr, bookVal);
}