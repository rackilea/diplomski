View view = findViewById(...) //or however you need it
LayoutParams lp = (LayoutParams) view.getLayoutParams();
   // margins are accessible via

lp.leftMargin;
lp.rightMargin;
lp.topMargin;
lp.bottomMargin;

// perhaps ViewGroup.MarginLayoutParams will work for you. It's a base class for //other LayoutParams.

ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) view.getLayoutParams();