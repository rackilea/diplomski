ConstraintSet constraintSet = new ConstraintSet();

//parent
ConstraintLayout orderProcessedLayout = new ConstraintLayout(getApplicationContext());
orderProcessedLayout.setId(ConstraintSet.PARENT_ID);
int constraintId = orderProcessedLayout.getId();

//Text View
TextView thanksTextView = new TextView(this);
thanksTextView.setId(View.generateViewId());
int textViewId = thanksTextView.getId();
orderProcessedLayout.addView(thanksTextView, 0);

//ButtonView
Button reOrderButton = new Button(this);
reOrderButton.setId(View.generateViewId());
int buttonViewId = reOrderButton.getId();
orderProcessedLayout.addView(reOrderButton, 1);

/*Setting Views Attributes*/
//Layout View
//setting constraints
constraintSet.clone(orderProcessedLayout);  //cloning ConstraintSet
constraintSet.setMargin(constraintId, ConstraintSet.START, 16);
constraintSet.setMargin(constraintId, ConstraintSet.END, 16);
constraintSet.setMargin(constraintId, ConstraintSet.TOP, 16);
constraintSet.setMargin(constraintId, ConstraintSet.BOTTOM, 16);

//Text View
CharSequence thanksText = "THANK YOU";
thanksTextView.setText(thanksText);
thanksTextView.setTextColor(Color.BLUE);
thanksTextView.setHighlightColor(Color.BLACK);

//setting constraints
constraintSet.connect(textViewId, ConstraintSet.START, constraintId, ConstraintSet.START);
constraintSet.connect(textViewId, ConstraintSet.END, constraintId, ConstraintSet.END);
constraintSet.connect(textViewId, ConstraintSet.TOP, constraintId, ConstraintSet.TOP);
constraintSet.connect(textViewId, ConstraintSet.BOTTOM, constraintId, ConstraintSet.BOTTOM);

//Button View
CharSequence reOrderText = "ORDER AGAIN";
reOrderButton.setText(reOrderText);

//Button Action
reOrderButton.setClickable(true);
reOrderButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        orderCancelled(null);
    }
});

//setting constraints
constraintSet.connect(buttonViewId, ConstraintSet.START, textViewId, ConstraintSet.START);
constraintSet.connect(buttonViewId, ConstraintSet.TOP, textViewId, ConstraintSet.BOTTOM);

//applying everything
constraintSet.applyTo(orderProcessedLayout);