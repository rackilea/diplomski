model = new SearchTermTableModel();
model.add(new SearchTerm(false, "Bananas"));
model.add(new SearchTerm(false, "Apples"));
model.add(new SearchTerm(false, "Streberries"));
model.add(new SearchTerm(false, "Poines with guns"));
model.add(new SearchTerm(false, "Anime"));
model.add(new SearchTerm(false, "Helicopters"));
model.add(new SearchTerm(false, "Sunny beaches which I'm not on"));

setLayout(new BorderLayout());
table = new JTable(model);
add(new JScrollPane(table));