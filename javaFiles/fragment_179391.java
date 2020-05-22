LinearLayout ll = new LinearLayout(this); 
 ll.setOrientation(LinearLayout.VERTICAL);
 TextView textView = new TextView(this);
 TextView textView2 = new TextView(this);
 ll.addView(textView);
 ll.addView(textView2);
 setContenView(ll);