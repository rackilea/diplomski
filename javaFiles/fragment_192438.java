//make ad visible on bottom of screen under surface
   LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
   params.gravity = Gravity.BOTTOM;
   params.weight = 0;
   adView.setLayoutParams(params);
   // my addition starts here
   //inLayout is linearlayout, that was what i thought but no.
   ViewGroup parent = (ViewGroup) adView.getParent(); // your linear layout
   if(parent.getChildCount() >0){
         View viewToTake = parent.getChildAt(0); // taking the first child element
         parent.remove(parent.indexOfChild(adView)); // you get the index of the adview layout and remove it
         parent.addView(adView,0); // adding it at the first position
         parent.addView(viewToTake,parent.getChildCount());// adding the view we took out back into play, you can decide to add it as the
         // second element since it was your initial first with parent.addView(viewToTake,1);