ConstraintLayout.LayoutParams prams = (ConstraintLayout.LayoutParams) imgActiveBar.getLayoutParams();
 prams.startToStart = btn1.getId(); //for example
 //you'll probably need to change the end position as well
 prams.endToEnd = btn1.getId();
 imgActiveBar.setLayoutParams(prams);
 imgActiveBar.requestLayout();