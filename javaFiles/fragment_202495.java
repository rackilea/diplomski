public void setSingleEvent(GridLayout maingrid) {
    for (int i = 0; i < maingrid.getChildCount(); i++) {
        final CardView cardView = (CardView) maingrid.getChildAt(i);
        final int finalI = i;

        cardView.setOnTouchListener(new OnTouchListener () {
          public boolean onTouch(View view, MotionEvent event) {
            if (event.getAction() == android.view.MotionEvent.ACTION_DOWN) {
              Toast.makeText(mcontext, "Button: " + finalI, Toast.LENGTH_SHORT).show();
              cardView.setCardBackgroundColor(mcontext.getResources().getColor(R.color.buttonPressed));
              if (finalI == 0) {
                  mcontext.startActivity(new Intent(mcontext, Genre_Streaming.class));
              }
            } else if (event.getAction() == android.view.MotionEvent.ACTION_UP) {
              /* Reset Color */
              cardView.setCardBackgroundColor(mcontext.getResources().getColor(R.color.red));
            }
            return true;
          }
        }
}