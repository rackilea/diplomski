if (i >= 0) { // let us assume that i = 0, we are getting inside
    Month month = months.get(i); // you are assigning first element of months, everything is fine
    monthTextView.setText("" + month); // some data operation - irrelevant
    i--; // anyway you are updating i to [i = -1]
}

// one "next" click later...

if (i < months.size()) { // condition is fine because i = -1
    Month month = months.get(i); // oooops tried to access months[-1] - ERROR
    monthTextView.setText("" + month);
    i++;
}