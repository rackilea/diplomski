@Override
 public void OnSelectionListener(String img, String comments) {
  DetailsView detailsView = new DetailsView();
  Bundle args=new Bundle();
  args.putString("img",img);
  args.putString("comments",comments);
  detailsView.setArguments(args);
  //code here to replace the fragment A with fragment B

  }