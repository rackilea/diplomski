setContentView(R.layout.main);

  // Now get a handle to any View contained 
  // within the main layout you are using
  View someView = findViewById(R.id.randomViewInMainLayout);

  // Find the root view
  View root = someView.getRootView();

  // Set the color
  root.setBackgroundColor(getResources().getColor(android.R.color.red));