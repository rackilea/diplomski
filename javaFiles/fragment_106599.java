int BASEID=200;

View v = mLayoutInflator.inflate(R.layout.myRelativeLayout, null);

for (int i;i<10;i++){
    v.findViewById(R.id.relativeView).setId(i+BASEID);
}

mRootView.addView(v,...);