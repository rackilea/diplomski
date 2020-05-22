lv = getListView();
   LayoutInflater inflater = getLayoutInflater();
   View header = inflater.inflate(R.layout.list_header, (ViewGroup) findViewById(R.id.header_layout_root));
   lv.addHeaderView(header, null, false);
   View relativeLayout = header.findViewById(R.id.header_layout_root1);
   TextView highScore = relativeLayout.findViewById(R.id.new_highscore);
   highScore.setVisibility(View.GONE);