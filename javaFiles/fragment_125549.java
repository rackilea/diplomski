int numCheckBox = item.numCheckBox;

if(numCheckBox == 1) {
    cb1.setVisibility(View.VISIBLE);
    cb2.setVisibility(View.GONE);
    cb3.setVisibility(View.GONE);
} else if(numCheckBox == 2) {
    cb1.setVisibility(View.VISIBLE);
    cb2.setVisibility(View.VISIBLE);
    cb3.setVisibility(View.GONE);
} else if(numCheckBox == 3) {
    cb1.setVisibility(View.VISIBLE);
    cb2.setVisibility(View.VISIBLE);
    cb3.setVisibility(View.VISIBLE);
}