setContentView(R.layout.activity_other);
final NavigationView navigationView = findViewById(R.id.nav_view);

navigationView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
    @Override
    public void onGlobalLayout() {
        TextView text = navigationView.findViewById(R.id.nav_header_textView);
        text.setText("Hello StackOverflow");
  navigationView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }
});