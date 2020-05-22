class MyActivity extends Activity {

    private MyListener delegate= new MyListener();

    // your existing code

    public boolean onKeyDown(int keyCode, KeyEvent event)  {
        delegate.onKeyDown(keyCode, event);
    }

}