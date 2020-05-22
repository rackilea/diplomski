TableRow.LayoutParams aLp = (TableRow.LayoutParams) a.getLayoutParams();
aLp.span = 0;
a.setLayoutParams(aLp);    

a.setVisibility(View.GONE);    

TableRow.LayoutParams bLp = (TableRow.LayoutParams) b.getLayoutParams();
bLp.span = 4;
b.setLayoutParams(bLp);