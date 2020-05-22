class  MyDragListener implements OnDragListener {

    @Override
    public boolean onDrag(View v, DragEvent event) {
        final int action = event.getAction();
        ClipData dragData;
        View p = (View) v.getParent();
        Object index = p.getTag();
        final int which = Integer.parseInt(index.toString());
        boolean handled = true;


        switch (action) {
            case DragEvent.ACTION_DRAG_STARTED: 
                dragSku = event.getClipDescription().getLabel().toString();                 
                break;

            case DragEvent.ACTION_DRAG_ENDED: 

                // Report the drop/no-drop result to the user
                final boolean dropped = event.getResult();
                compareInMotion = false;
                BaseAdapter lva = (BaseAdapter) gridview.getAdapter();
                lva.notifyDataSetChanged();
               break;

            case DragEvent.ACTION_DROP:
                // just drop it
                    ((ImageView) v).setImageBitmap(emptyImg);
                    setUpCompareItem((ImageView) v, dragSku);   break;

            default :
                break;                
        }
        return handled;