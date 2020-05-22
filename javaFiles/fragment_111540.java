private ConstraintSet myConstraintSet = new ConstraintSet();

...

CustomEditText myCustomView = new CustomEditText(new ContextThemeWrapper(this, R.style.CustomStyle), null, 0);
myCustomView.setId(View.generateViewId()); 
myConstraintLayout.addView(tag);

myConstraintSet.clone(myConstraintLayout);

myConstraintSet.connect(myCustomView.getId(), ConstraintSet.START, myConstraintLayout.getId(), ConstraintSet.START);
myConstraintSet.connect(myCustomView.getId(), ConstraintSet.END, myConstraintLayout.getId(), ConstraintSet.END);

myConstraintSet.applyTo(myConstraintLayout);