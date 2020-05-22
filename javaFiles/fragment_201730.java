LinearLayout layout = setupLayout();
int count = layout.getChildCount();
View v = null;
for(int i=0; i<count; i++) {
    v = layout.getChildAt(i);
    if (v instanceof ImageButton) {
        v.setEnabled(false);
        v.setAlpha(6); 
    }
}