//Getting your relative layout where you are going to place your events
ViewGroup dayplanView = (ViewGroup) layout.findViewById(R.id.mytimetable);

//Inflating your eventview but not adding it yet. Note that event_layout is your event layout resource.
View eventView = inflater.inflate(R.layout.event_layout, dayplanView, false);
//Getting its current layoutparams in order to change them
RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) eventView.getLayoutParams();
//Setting its height (in pixels) (1h 30min)
layoutParams.height = dpToPixels(90);
//Setting topmargin (in pixels) (1.30am)
layoutParams.topMargin = dpToPixels(90);
//Adding layoutparams back to the view
eventView.setLayoutParams(layoutParams);
//Adding your eventview to the relativeview
dayplanView.addView(eventView);