private Tool mTool;

@Override
public void onViewCreated(View view,Bundle savedInstanceState) {
    // obtain view references
    if (mTool != null) {
        updateDisplay();
    }
}

public void setTool(Tool tool) {
    mTool = tool;
    if (getView() != null) {
        updateDisplay();
    }
}

private void updateDisplay() {
    // change UI here
}