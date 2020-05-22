final RippleDrawable rippleDrawable = (RippleDrawable) convertView.getBackground();
final View finalParent = parent;
final int finalPosition = position;
View.OnTouchListener listener = new View.OnTouchListener() {
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                rippleDrawable.setHotspot(motionEvent.getX(), motionEvent.getY());
                rippleDrawable.setState(new int[] {android.R.attr.state_pressed, android.R.attr.state_enabled});
                return true;
            case MotionEvent.ACTION_UP:
                rippleDrawable.setState(new int[0]);
                ((ListView)finalParent).performItemClick(view, finalPosition, 0);
                return true;
        }
        return false;
    }
};