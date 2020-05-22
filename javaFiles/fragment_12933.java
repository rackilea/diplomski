@Override
public void done(List<Society> societies) {
    ListView lv = (ListView) findViewById(R.id.ListView);
    List<ListViewItem> items = new ArrayList<>();
    for(Society s : societies) {
        items.add(new ListViewItem() {{
            ThumbnailResource = R.drawable.test;
            Title = s.socName;
            Subtitle = s.socDes;
        }});
    }
    CustomListViewAdapter adapter = new CustomListViewAdapter(
        SocietySearch.this, items);
    lv.setAdapter(adapter);
}`