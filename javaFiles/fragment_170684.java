/** Assign textview array lenght by arraylist size */
name = new TextView[sitesList.getName().size()];
website = new TextView[sitesList.getName().size()];
//category = new TextView[sitesList.getName().size()];

/** Add rows for every entry and add it to layout */
for (int i = 0; i < sitesList.getName().size(); i++) {
    //we can leave that part as it is
    name[i] = new TextView(this);
    name[i].setText("Name = "+sitesList.getName().get(i));

    website[i] = new TextView(this);
    website[i].setText("Website = "+sitesList.getWebsite().get(i));

    //now we create a new row
    TableRow row = new TableRow(this);

    //we add the textviews to the row
    row.addView(name[i]);
    row.addView(website[i]);

    //and we add the row to the tablelayout
    layout.addView(row);
}