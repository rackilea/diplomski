LinearLayout ll;

for ( int i = 0; i < ll.getChildCount(); i++ ) {
    View child = ll.getChildAt(i);
    if ( child instanceof CheckBox ) {
        boolean checked = ((CheckBox) child).isChecked();
    }
}