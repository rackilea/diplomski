Calendar wek = Calendar.getInstance(Locale.US);
wek.add(Calendar.WEEK_OF_YEAR,r);

//this will set your calendar onto the first day of the week
int w = wek.get(Calendar.WEEK_OF_YEAR);
int y = wek.get(Calendar.YEAR);
wek.clear();
wek.set(Calendar.YEAR, y);
wek.set(Calendar.WEEK_OF_YEAR, w);
//get the month and year of the first day of the week
int m1 = wek1.get(Calendar.MONTH);
int y1 = wek1.get(Calendar.YEAR);

//get the date for the end of the week and its month and year
Calendar w2 = wek;
w2.add(Calendar.DATE, 6);
int m2 = w2.get(Calendar.MONTH);
int y2 = w2.get(Calendar.YEAR);

if(m1 == m2) {
    //if the two months are the same, then just format the date
    SimpleDateFormat gm = new SimpleDateFormat("MMM yyyy");
    mes.setText(gm.format(wek.getTime()));
}
else if(y1 == y1) {
    //different months, same year - format as "MMM - MMM yyyy"
    SimpleDateFormat gm = new SimpleDateFormat("MMM");
    SimpleDateFormat gy = new SimpleDateFormat("yyyy");
    mes.setTextText(gm.format(wek.getTime()) + " - " +
                    gm.format(w2.getTime()) + " " +
                    gy.format(wek.getTime()));
}
else {
    //Different months and different years - format as "MMM yyyy - MMM yyyy"
    SimpleDateFormat gm = new SimpleDateFormat("MMM yyyy");
    mes.setTextText(gm.format(wek.getTime()) + " - " +
                    gm.format(w2.getTime()));
}