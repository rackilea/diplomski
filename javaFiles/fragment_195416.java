@Override public boolean onTouch(View v, MotionEvent event) { 
    int action = event.getAction();

    if(action == MotionEvent.ACTION_DOWN)
    {
         captureInput = true;
    }
    else if(action == MotionEvent.ACTION_MOVE
    {
        //get x/y of your finger
         int X = (int)event.getX();   
         int Y = (int)event.getY();

        //Somehow check if the x,y are overlapping with one of your textivews
        // If so, add that textview's text to your list
        // Below is pseudo code
        /* for(TextView curTV: allTextViews)
           {
               if(isOverlapping(X,Y))
               {
                   listOfSwipedCharacters.add(curTV.getText());
               }
           }
     }


}