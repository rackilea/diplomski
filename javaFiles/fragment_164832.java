int[] views = new int[] { R.id.btn1, R.id.btn2, R.id.btn3, ...... R.id.btn9 };

for (int i= 0; i< views.length ;i++)
{
   Button button = (Button)findViewById(views[i]);
   button.setOnTouchListener(new View.OnTouchListener() {
        @Override public boolean onTouch(View v, MotionEvent event) {
             ...
        }
   });
}