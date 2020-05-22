setContentView(R.layout.activity_gr);
ConstraintLayout layout = findViewById(R.id.my_container)
ConstraintSet constraints = new ConstraintSet();
constraints.clone(layout);
// Edit constraints of the constraints set
// Apply your new constraints to the inflated layout
constraints.applyTo(layout)