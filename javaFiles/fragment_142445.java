Label label = new Label();
label.setText("bla");
label.setTextAlignment(PositionConstants.CENTER);

RoundedRectangle fig = new RoundedRectangle();    
fig.setLayoutManager(new BorderLayout());
fig.add(label, BorderLayout.CENTER);