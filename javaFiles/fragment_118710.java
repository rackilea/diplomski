ListView listView = getListView(); 
ImageView mListHeader = new ImageView(getContext()); 
mListHeader.setImageResource(R.drawable.individuals_img); 
mListHeader.setScaleType(ImageView.ScaleType.FIT_XY); 
mListHeader.setLayoutParams(new AbsListView.LayoutParams(1400,974)); 
mListHeader.requestLayout(); 
listView.addHeaderView(mListHeader);