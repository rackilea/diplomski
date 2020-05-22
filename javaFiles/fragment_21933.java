LinearLayout ll = (LinearLayout)findViewById(R.id.yourLinearLayout);
 Button m =new  Button(getActivity());
 m.setText("adfgadgfdsfg");
 m.setWidth(100);
 m.setHeight(30);
 m.setTextSize(30);
 ll.addView(m); 

 Button m1 =new  Button(getActivity());
 m1.setText("adfgadgfdsfg");
 m1.setWidth(100);
 m1.setHeight(30);
 m1.setTextSize(30);
 ll.addView(m1);

 scroller.addView(ll);