m_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            if (mAdapter.getLink(position) == null) {}
            else {
                String linked = mAdapter.getLink(position);
                Uri url = Uri.parse("https://"+linked);
                Intent intent = new Intent(Intent.ACTION_VIEW, url);
                startActivity(intent);
            }
        }
    });

}