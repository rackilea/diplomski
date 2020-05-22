public static class JustClickableMethod extends LinkMovementMethod {

    public static MovementMethod getInstance() {
        return new JustClickableMethod();
    }

    @Override
    public boolean onTouchEvent(TextView widget, Spannable buffer, MotionEvent event) {

        int action = event.getAction() & MotionEvent.ACTION_MASK;

        if( action != MotionEvent.ACTION_UP ) {

            return true;
        }

        return super.onTouchEvent(widget, buffer, event);
    }

}