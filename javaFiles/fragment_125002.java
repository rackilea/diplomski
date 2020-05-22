public boolean onTouchEvent(MotionEvent event){  
    int itemID = 0;
    int X = (int)event.getX(); 
    int Y = (int)event.getY(); 

        switch(event.getAction()){
             case MotionEvent.ACTION_DOWN:
                for(Items item : dragable_item){

                    //center coords of the item
                    int centerX = item.getX() + 25;
                    int centerY = item.getY() + 25;

                    //calculate the distance (radius) from touch to item

                    //get item to drag
                    if(distance < 20){
                        itemId = item.getID(); break;
                    }
                }
             break;
             case MotionEvent.ACTION_MOVE:
                 if(itemID > 0){
                     Items[itemID-1].setX(X-25);
                     Items[itemID-1].setY(X-25);
                 }
             break;
        }
    }
    invalidate(); return true;
}