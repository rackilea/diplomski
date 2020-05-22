OnTouchListener otl = new OnTouchListener() {
      @Override
      public boolean onTouch(View v, MotionEvent event) {
          switch (event.getAction()) {
          case MotionEvent.ACTION_DOWN:
              Layout layout = ((EditText) v).getLayout();
              float x = event.getX() + secondText.getScrollX();
              int offset = layout.getOffsetForHorizontal(0, x);
              if(offset>0)
                  if(x>layout.getLineMax(0))
                      secondText.setSelection(offset);     // touch was at end of text
                  else
                      secondText.setSelection(offset - 1);
              break;
              }
          return true;
          }
      };
      secondText.setOnTouchListener(otl);