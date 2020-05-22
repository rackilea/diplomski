public void addButtonImage () {
    ConstraintLayout conL = (ConstraintLayout)findViewById(R.id.newLayout);
    ImageButton previewImg = new ImageButton(this);
    Guideline leftGl = (Guideline)findViewById(R.id.leftGideLine);
    Guideline rightGL = (Guideline)findViewById(R.id.rightGuideLine);
    ImageView header = (ImageView) findViewById(R.id.Header);

    previewImg.setImageResource(R.mipmap.ic_launcher); // displayImage variable assigned out of method
    previewImg.setBackgroundColor(Color.parseColor("#FFFF00"));
    conL.addView(previewImg);

    ConstraintSet conS = new ConstraintSet();
    conS.clone(conL);

    conS.constrainHeight(pp.getId(), 90);
    conS.constrainWidth(pp.getId(), 0);
    conS.connect(previewImg.getId(), ConstraintSet.TOP, header.getId(), ConstraintSet.BOTTOM);
    conS.connect(previewImg.getId(), ConstraintSet.LEFT, leftGl.getId(), ConstraintSet.RIGHT);
    conS.connect(previewImg.getId(), ConstraintSet.RIGHT, rightGL.getId(), ConstraintSet.LEFT);
    conS.applyTo(conL);
}