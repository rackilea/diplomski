final StringBuilder sb = ... ;
final TextView tv = ... ;

tv.post(new Runnable() {
        public void run() {
            tv.setText(sb.toString());
        }
    });