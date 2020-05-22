int size = 10;
switch(view.getId()) {
            case R.id.rbsmall:
                if (checked)
                   size = 12;
                break;  

// other case

}

  ViewGroup root = (ViewGroup) findViewById(R.id.rootLayout);
  int children = root.getChildCount();
  for (int i = 0; i < children; i++) {
      View view  = root.getChildAt(i);
      if (view instanceOf TextView) {
        TextView tmp = (TextView)view;
        view.setText(size);
      }
  }