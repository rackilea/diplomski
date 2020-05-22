/** Assign textview array lenght by arraylist size */
name = new TextView[sitesList.getName().size()];
website = new TextView[sitesList.getName().size()];
//category = new TextView[sitesList.getName().size()];

/** Set the result text in textview and add it to layout */
for (int i = 0; i < sitesList.getName().size(); i++) {
    name[i] = new TextView(this);
    name[i].setText("Name = "+sitesList.getName().get(i));
    website[i] = new TextView(this);
    website[i].setText("Website = "+sitesList.getWebsite().get(i));
    /**category[i] = new TextView(this);
    category[i].setText("Website Category = "+sitesList.getCategory().get(i));**/

    layout.addView(name[i]);
    layout.addView(website[i]);
    //layout.addView(category[i]);
}