LayoutInflater layoutInflater = (LayoutInflater) 
     context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
     View root = layoutInflater.inflate(R.layout.yourLayout, null);
     // for footerclick
     //add code her root.setOnClickListner(...)
     listView.addFooterView(root, null, true);