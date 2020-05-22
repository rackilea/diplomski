@Override
public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {        
    ...

    if (actionState == ItemTouchHelper.ACTION_STATE_SWIPE) {
         ...

         if (dX > 0) {
             ...

             recyclerView.setOnTouchListener((v, event) -> {
                 int left = itemView.getLeft() + width;
                 int top = itemView.getTop() + height;
                 int right = left + bitmap.getWidth();
                 int bottom = top + bitmap.getHeight();

                 if (actionState == ItemTouchHelper.ACTION_STATE_SWIPE &&
                     event.getAction() == MotionEvent.ACTION_DOWN &&
                     event.getX() >= left && event.getX() <= right &&                  
                     event.getY() <= bottom && event.getY() >= top
                    ) {
                    // Do what you want to do here...
                    onEditClicked(viewHolder.getAdapterPosition());
                }
                return false;
            });

         } else {
             ...
         }
     }
}