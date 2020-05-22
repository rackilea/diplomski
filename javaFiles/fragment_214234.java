case DragEvent.ACTION_DROP:        
    //handle the dragged view being dropped over a target view
    View view = (View) draggedView.getLocalState(); 

    //stop displaying the view where it was before it was dragged
    view.setVisibility(View.INVISIBLE); 

    //view dragged item is being dropped on
    ImageView dropTarget = (ImageView) dropTargetView; 
    //view being dragged and dropped
    ImageView dropped = (ImageView) view;

    // In this case the "dropTarget" is the "top most" ImageView of my stacked circles
    // I can create a ViewGroup of the parent of this ImageView (which is the 
    // RelativeLayout) in order to check all the children (other ImageViews)
    ViewGroup vg = (ViewGroup) dropTarget.getParent();

    Object tag = dropped.getTag();

    // Now I can iterate through each of the children (ImageViews) in the ViewGroup
    // looking to see if the dragged puzzle piece is a match for one of the "drop"
    // ImageViews
    for(int i = 0; i<vg.getChildCount(); i++){
        ImageView temp = (ImageView) vg.getChildAt(i);
        Object dtag = temp.getTag();
            if(dtag.toString().equals(tag.toString())){
                // Then we have a match! Place the piece