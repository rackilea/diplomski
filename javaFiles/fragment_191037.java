@Override
protected void onCreate(Bundle savedInstanceState) {
    YourState state = loadState();
    // Rebuild your activity based on state
    someView.setText(state.getCustomAtt())
}