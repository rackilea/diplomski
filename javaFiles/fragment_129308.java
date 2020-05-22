@Override
protected void onCreate(@Nullable Bundle savedInstanceState) {
    (...)
    final View = findViewById(R.id.view);
    final ViewTreeObserver observer= view.getViewTreeObserver();
    observer.addOnGlobalLayoutListener(
        new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                Log.d("Log", "Height: " + view.getHeight());
                Log.d("Log", "Width: " + view.getWidth());
            }
        });
}