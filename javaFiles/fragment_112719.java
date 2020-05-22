for(int i=0 ; i < 2 ; i++) {
TableRow tr = new TableRow(this);



    tr.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
    tr.setBackgroundResource(R.drawable.border);

linearUserPicture = new View(); //DON'T COPY THIS! re create your view as you did it before every time
    tr.addView(linearUserPicture); // INITIALIZE linearUserPicture every loop!
tl.addView(tr, new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.MATCH_PARENT));
}