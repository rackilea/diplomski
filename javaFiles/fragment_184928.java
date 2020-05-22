setContentView(R.layout.activity_main);
LinearLayout ll = (LinearLayout)findViewById(R.id.linearLayout);
// linear layout or relative layout in activity_main.xml.
// place the layout ahere you want along with other views  
Draw draw = new Draw(this); 
ll.addView(draw);  
// add your customview to linearlayout