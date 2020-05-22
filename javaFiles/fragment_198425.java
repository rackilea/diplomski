private Handler handler;
public void onCreate(Bundle x) {
     //super and get bt
     final Button bt = findViewById(R.id.button);
     handler = new Handler() {
           public void handleMessage(Message msg) {
                if(msg.what == 0)
                     bt.setText("Click!");
                else
                     bt.setText(String.toString(msg.what));
           }
     }
}

public void buttonOnClick (View button) {
   final Button bt = findViewById(R.id.button);
   bt.setText("3");
   //wait 1 second
   handler.sendEmptyMessageDelayed(2, 1000);
   //wait 2 second
   handler.sendEmptyMessageDelayed(1, 2000);
   //wait 3 second
   handler.sendEmptyMessageDelayed(0, 1000);
   bt.setText("Click!");
}