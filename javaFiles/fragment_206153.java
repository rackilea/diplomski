@Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                // if we can scroll pass the event to the superclass
                if (mScrollable) return super.onTouchEvent(ev); //return mScrollable condition is false

/*
*Write your code here to implement your functionality like if you image view is touched
*/
                    // only continue to handle the touch event if scrolling enabled
                    return mScrollable; // mScrollable is always false at this point
    // mScrollable flag may  help you 
//use it as a condition
                    default:
                        return super.onTouchEvent(ev);
                }
            }




@Override  
public boolean onInterceptTouchEvent(MotionEvent ev) {
    switch (ev.getAction()) {     
    case MotionEvent.ACTION_DOWN:         
        // if we can scroll pass the event to the superclass      
        if (mScrollable) return super.onInterceptTouchEvent(ev);      
        // only continue to handle the touch event if scrolling enabled    
        return mScrollable; // mScrollable is always false at this point     
        default:          
            return super.onInterceptTouchEvent(ev);      
            }
    }