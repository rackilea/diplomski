dates = [...]; // list you have now;

// build list
unused = [];
for (Date i = startdate; i < enddate; i += day) {
    unused.push(i);
}

// remove used dates
for (int j = 0; j < dates.length; j += 1) {
    if (unused.indexOf((Date) dates[j]) > -1) { // time = 00:00:00
        unused.remove(unused.indexOf((Date) dates[j]));
    }
}