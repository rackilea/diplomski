listView.setOnItemClickListener(new OnItemClickListener() {
        public void onItemClick(AdapterView<?> parent, View view,
            int position, long id) {

    if (position==0) {
            Intent news = new Intent(Menu.this ,RSSItem.class);
            startActivity(news);
    }else if (position==1) {
            Intent calendar = new Intent(Menu.this ,calender.class);
            startActivity(news);
    }
 // and so on
}