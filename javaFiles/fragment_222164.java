public void Listen() {

    list.setOnItemClickListener(new AdapterView.OnItemClickListener() {  
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            NewsItem selectedNews = (NewsItem) parent.getItemAtPosition(position);
            Intent i = new Intent(MainActivity.this, News_Details_Activity.class);
            i.putExtra("title", selectedNews.getTitle());
            i.putExtra("date", selectedNews.getNewsDate().toString());
            i.putExtra("image_id", selectedNews.getImageId());
            i.putExtra("text", selectedNews.getText());
            startActivity(i);
        }

    });
}