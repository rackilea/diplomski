public class MyListerer implement KeyListener {

    public void onKeyDown(int keyCode, KeyEvent event){
        Toast.makeText(this, "Hey world!", Toast.LENGTH_LONG).show();
    }
}