int criteria;

Intent intent = getIntent();
goodsList = (List<Goods>) intent.getSerializableExtra("listbarang");
criteria = intent.getIntExtra("criteria", 0);

// do something based on criteria
for(Goods good: goodsList) {
  if(good.getStock >= criteria) {
    // process the good.
  }
}