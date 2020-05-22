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

        //Somehow check which textview the X,Y coords are overlapping
        // Below is pseudo code
        /* for(TextView curTV: allTextViews)
           {
               if(isOverlapping(X,Y))
               {
                   listOfSwipedCharacters += (curTV.getText());
               }
           }*/
     }
     else if(action == MotionEvent.ACTION_UP)
     {
         captureInput = false;
         //Do whatever you want with the string of information that you've captured
     }