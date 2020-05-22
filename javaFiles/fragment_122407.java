Table table = new Table();
table.add(mLabel);
table.row();
table.add(mButton);
table.row();

// Changing the table layout size itself.
table.add(mListScroll).size(500, 500);

mStage.addActor(table);