int flag=0
    layout.setOnTouchListener(new View.OnTouchListener() {
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_UP) {
            if(flag==0){
              //do something 
            }else{
              flag=0;
            }

        }
        return false;
    }
});
layout.setOnLongClickListener(new View.OnLongClickListener() {
    @Override
    public boolean onLongClick(View v) {
        flag=1
        return true;
    }
});