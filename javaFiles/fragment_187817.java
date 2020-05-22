articleList.setOnItemClickListener(new OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> arg0, View arg1, int position,
                long id) {
            String url = articleList.get(position).getUrl();
            Intent i = new Intent(MainActivity.this,   WebViewActivity.class);
            i.putExtra("url", url);
            startActivity(i);
        }
    });