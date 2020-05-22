ConstraintLayout layout = (ConstraintLayout) inflate(context, R.layout.card, this);

// We have added R.layout.card to a ConstraintLayout (this custom layout), so we need
// to make sure that it is constrained properly.
ConstraintSet cs = new ConstraintSet();
cs.clone(layout);
cs.connect(R.id.layout, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START);
cs.connect(R.id.layout, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP);
cs.connect(R.id.layout, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END);
cs.connect(R.id.layout, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM);
cs.applyTo(layout);