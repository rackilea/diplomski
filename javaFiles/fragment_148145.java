EditText mText = ....
final int[] beginOffset = {-1};
View.OnTouchListener otl = new View.OnTouchListener() {
   @Override
   public boolean onTouch(View v, MotionEvent event) {
       if(event.getToolType(0) == MotionEvent.TOOL_TYPE_MOUSE){//only change behavior for mouse
                int i = event.getAction();
                if (i == MotionEvent.ACTION_DOWN) {
                    Layout layout = ((EditText) v).getLayout();
                    float x = event.getX() + mText.getScrollX();
                    float y = event.getY() + mText.getScrollY();
                    int line = layout.getLineForVertical((int) y);                                  
                    int offset = layout.getOffsetForHorizontal(line, x);
                    if (offset > 0) {          
                        if (x > layout.getLineMax(0)){
                            beginOffset[0] = offset;//store beginning offset
                            mText.setSelection(offset); // touch was at end of text
                        }
                        else{
                            beginOffset[0] = offset - 1;//store beginning offset
                            mText.setSelection(offset - 1);
                        }
                    }

                } else if (i == MotionEvent.ACTION_UP) {
                    if (beginOffset[0] != -1) {//has previous down action
                        Layout layout = ((EditText) v).getLayout();
                        float x = event.getX() + mText.getScrollX();
                        float y = event.getY() + mText.getScrollY();  
                        int line = layout.getLineForVertical((int) y);                                            
                        int offset = layout.getOffsetForHorizontal(line, x);
                        if (offset > 0){
                            if (x > layout.getLineMax(0))
                                mText.setSelection(Math.min(offset, beginOffset[0]), Math.max(offset, beginOffset[0])); // touch was at end of text
                            else
                                mText.setSelection(Math.min(offset - 1, beginOffset[0]), Math.max(offset - 1, beginOffset[0]));
                        }
                        beginOffset[0] = 0;//clear beginning offset
                    }
                } else if (i == MotionEvent.ACTION_MOVE) { //selects as mouse moves
                    if (beginOffset[0] != -1) {//has previous down action
                        Layout layout = ((EditText) v).getLayout();
                        float x = event.getX() + mText.getScrollX();
                        float y = event.getY() + mText.getScrollY();
                        int line = layout.getLineForVertical((int) y);
                        int offset = layout.getOffsetForHorizontal(line, x);
                        if (offset > 0){
                            if (x > layout.getLineMax(0))
                                mText.setSelection(Math.min(offset, beginOffset[0]), Math.max(offset, beginOffset[0])); // touch was at end of text
                            else
                                mText.setSelection(Math.min(offset - 1, beginOffset[0]), Math.max(offset - 1, beginOffset[0]));
                        }
                    }
                }
                return true;
            }
            return false;//default behavior otherwise
        }
    };