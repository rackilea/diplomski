override fun onChildDraw(c: Canvas, recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, dX: Float, dY: Float, actionState: Int,isCurrentlyActive: Boolean) {
    if(actionState == ItemTouchHelper.ACTION_STATE_SWIPE){
        setupMyFlag()
    }
}
override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
    clearMyFlag()
}