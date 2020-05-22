@Override
public boolean onTouch(View v, MotionEvent event) {
    ImageView iv = (ImageView) v;

    if (event.getAction() == MotionEvent.ACTION_DOWN) {
        iv.setImageResource(R.drawable.button_white_pressure);
        return true;
    } else if (event.getAction() == MotionEvent.ACTION_UP) {
        iv.setImageResource(R.drawable.button_white);
        return true;
    }

    return false;
}