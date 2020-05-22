public class SlovnikoidActivity extends Activity {
    //slovnikoidActivity definition

    //inner class definition for MyOnClickListener
    class MyOnClickListener implements OnClickListener {
        private CharSequence[] items;

        public MyOnClickListener(CharSequence[] _items) {
            items = _items;
        }

        public void onClick(View v) {
            AlertDialog.Builder builder = new AlertDialog.Builder(SlovnikoidActivity.this);
            builder.setTitle("test");
            builder.setItems(items, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int item) {
                    Toast.makeText(getApplicationContext(), items[item], Toast.LENGTH_SHORT).show();
                    langFrom.setText(items[item]);
                }
            });
            AlertDialog alert = builder.create();
            alert.show();
        }
    }
}