@Override
public boolean onEditorAction(TextView textView, int actionId, KeyEvent event) {

    if (event != null && event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {

        switch (event.getAction()) {

        case KeyEvent.ACTION_DOWN:
            // for some reason we can get tons of repeated down events in the debugger, maybe from keyboard auto-repeat?
            return true;

        case KeyEvent.ACTION_UP:

            // *** put your event code here ***

            return true;
        }

    }
}