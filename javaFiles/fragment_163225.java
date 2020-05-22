@Override 
public Object instantiateItem(ViewGroup container, int position) { 
View v = mShopcards.get(position);
 container.addView(v);
 return container;
 }