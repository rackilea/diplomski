View.OnClickListener listener = new View.OnClickListener() {
  @Override public void onClick(View v) {
    File path = (File) v.getTag();  
  }
};

LinearLayout breadcrumbs = new LinearLayout(...);
breadcrumbs.setOrientation(LinearLayout.HORIZONTAL);

Button path1 = new Button(...);
path1.setTag(new File(...)); // will be retrieved on click
path1.setOnClickListener(listener); // so now on code above you can open path


// ... add bread crumbs

breadcrumbs.addView(path1);