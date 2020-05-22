public void click_button1 (View view){ 
        TextView textview=(TextView)parent.findViewById(R.id.textView1); 
          if(!textview.isShown())  //Check if the view is currently visible or not.
             textview.setVisibility(View.VISIBLE);
         else
             textview.setVisibility(View.INVISIBLE);
     }